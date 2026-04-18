package com.Main.dto.request;

import java.math.BigDecimal;

import com.Main.constant.TeaInputType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeaInput {

    private String teaType; // pending_tea, free_tea, etc

    private TeaInputType inputType; // QUANTITY or AMOUNT

    private BigDecimal value; // either quantity OR amount

}
