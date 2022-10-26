package com.example.demo.controller;

import com.example.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    @Autowired
    private OperationService operationService;
}
