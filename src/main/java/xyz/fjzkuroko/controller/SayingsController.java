package xyz.fjzkuroko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.service.SayingsService;

@RestController
@RequestMapping("/sayings")
public class SayingsController {

    @Autowired
    private SayingsService sayingsService;

    @RequestMapping("/getAllSayings")
    public ResponseMessage getAllSayings() {
        return ResponseMessage.newOkInstance(sayingsService.getAllSayings());
    }

}
