package com.store.movie.impl;

import com.store.movie.entity.Review;
import com.store.movie.repository.ReviewRepository;
import com.store.movie.service.ReviewService;
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
