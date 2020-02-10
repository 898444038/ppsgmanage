package com.ming.ppsg.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PpsgController {

    @RequestMapping("/list")
    public String list() {
        return "list,list,list,list,list,list,list,list";
    }

}