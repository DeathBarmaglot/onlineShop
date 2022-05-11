package com.store.movie.controller;

import com.store.movie.entity.Review;
import com.store.movie.service.impl.DefaultReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/review")
public class ReviewController {

    private final DefaultReviewService reviewService;

    @GetMapping()
    public Iterable<Review> getAll() {
        return reviewService.getAllReviews();
    }
}
