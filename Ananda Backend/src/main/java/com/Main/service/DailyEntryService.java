package com.Main.service;

import com.Main.dto.request.DailyEntryRequest;
import com.Main.dto.response.DailyEntryResponse;
import com.Main.entity.DailyEntry;

public interface DailyEntryService {

    DailyEntryResponse createEntry(DailyEntryRequest request);
}