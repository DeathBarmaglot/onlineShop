package com.store.movie.entity.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String nickname;
    private String text;
}
