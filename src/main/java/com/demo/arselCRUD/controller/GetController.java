package com.demo.arselCRUD.controller;

import com.demo.arselCRUD.service.GetService;
import com.demo.arselCRUD.utils.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GetController {

    @Autowired
    GetService getService;
    @GetMapping("/getAll")
    public ResponseEntity<MessageModel> getAllBarang() {
        return getService.getAll();
    }
}
