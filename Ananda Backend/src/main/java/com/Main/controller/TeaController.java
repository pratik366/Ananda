package com.Main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Main.dto.request.TeaRequest;
import com.Main.dto.response.TeaResponse;
import com.Main.service.impl.TeaServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/tea")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TeaController {

    private final TeaServiceImpl teaServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<TeaResponse> createTea(
        @RequestBody TeaRequest teaRequest
    ){
        TeaResponse response = teaServiceImpl.createTea(teaRequest);
        return ResponseEntity.ok(response);
    }
    
}
