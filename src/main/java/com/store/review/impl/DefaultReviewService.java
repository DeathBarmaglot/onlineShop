package com.store.review.impl;

import com.store.review.Review;
import com.store.review.ReviewRepository;
import com.store.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultReviewService implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
