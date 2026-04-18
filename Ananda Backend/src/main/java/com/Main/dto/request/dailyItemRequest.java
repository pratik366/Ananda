package com.Main.dto.request;

import lombok.Data;

@Data
public class dailyItemRequest {

    private Long itemId;
    private Integer todayQty;
     private Integer todaySold; 
}
