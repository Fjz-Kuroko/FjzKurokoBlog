package xyz.fjzkuroko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.service.LabelsService;

@RestController
@RequestMapping("/labels")
public class LabelsController {

    @Autowired
    private LabelsService labelsService;

    @RequestMapping("/getLabelByLid")
    public ResponseMessage getLabelByLid(int lid) {
        return ResponseMessage.newOkInstance(labelsService.getLabelByLid(lid));
    }

    @RequestMapping("/getAllLabelsAndArticleNum")
    public ResponseMessage getAllLabelsAndArticleNum() {
        return ResponseMessage.newOkInstance(labelsService.getAllLabelsAndArticleNum());
    }

}
