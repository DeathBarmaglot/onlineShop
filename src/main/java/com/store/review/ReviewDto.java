package com.store.review;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String nickname;
    private String text;
}
