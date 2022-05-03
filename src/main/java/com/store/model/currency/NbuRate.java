package com.store.model.currency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NbuRate {
    private String r030;
    private String txt;
    private double rate;
    private String cc;
    private String exchangedate;
}
