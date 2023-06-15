package com.server.sent.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FlightInfo {

    private long id;
    private String to;
    private String from;
    private BigDecimal price;

}
