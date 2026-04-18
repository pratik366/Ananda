package com.Main.service;

import com.Main.dto.request.TeaRequest;
import com.Main.dto.response.TeaResponse;

public interface TeaService {
    TeaResponse createTea(TeaRequest request);
}
