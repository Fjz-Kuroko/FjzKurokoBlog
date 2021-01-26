package xyz.fjzkuroko.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.util.EhcacheUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private DefaultKaptcha producer;

    @PostMapping("/image")
    public ResponseMessage image() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //获取验证码
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        try {
            ImageIO.write(image, "png", out);
            String base64bytes = Base64.encode(out.toByteArray());
            //该字符串传输至前端放入src即可显示图片，安卓可以去掉data:image/png;base64,
            String src = "data:image/png;base64," + base64bytes;
            // 获取随机的uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            // 把验证码存进缓存
            EhcacheUtil.insertCaptchaCode(uuid, text.toLowerCase());
            Map<String, Object> map = new HashMap<>(2);
            map.put("uuid", uuid);
            map.put("img", src);
            return ResponseMessage.newOkInstance(map);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseMessage.newErrorInstance(e, "验证码获取错误！");
        }
    }

    @Bean
    public DefaultKaptcha producer(){
        Properties properties = new Properties();
        properties.put("kaptcha.border", "yes");
        properties.put("kaptcha.border.color", "105,179,90");
        properties.put("kaptcha.textproducer.font.color", "blue");
        properties.put("kaptcha.image.width","90");
        properties.put("kaptcha.image.height","40");
        properties.put("kaptcha.textproducer.font.size","20");
        properties.put("kaptcha.textproducer.char.space", "3");
        properties.put("kaptcha.textproducer.char.length","4");
        properties.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.put("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        properties.put("kaptcha.background.clear.from", "0,148,255");
        properties.put("kaptcha.background.clear.to", "white");

        properties.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
