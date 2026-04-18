package com.Main.service;

import com.Main.dto.request.MilkRequest;
import com.Main.dto.response.MilkResponse;

public interface MilkService {

    MilkResponse createMilk(MilkRequest request);
}