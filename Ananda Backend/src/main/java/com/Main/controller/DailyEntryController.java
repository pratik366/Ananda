package com.Main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Main.dto.request.DailyEntryRequest;
import com.Main.dto.response.DailyEntryResponse;
import com.Main.service.DailyEntryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dailyItem")
@RequiredArgsConstructor
public class DailyEntryController {

    private final DailyEntryService dailyEntryService;

    @PostMapping("/create")
    public ResponseEntity<DailyEntryResponse> createDailyEntry(
            @RequestBody DailyEntryRequest request) {

        DailyEntryResponse response = dailyEntryService.createEntry(request);

        return ResponseEntity.ok(response);
    }
}
