package com.Main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Main.dto.request.MilkRequest;
import com.Main.dto.response.MilkResponse;
import com.Main.service.MilkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/milk")
@RequiredArgsConstructor
public class MilkController {

    private final MilkService milkService;

    @PostMapping
    public ResponseEntity<MilkResponse> createMilk(@RequestBody MilkRequest request) {
        return ResponseEntity.ok(milkService.createMilk(request));
    }
}