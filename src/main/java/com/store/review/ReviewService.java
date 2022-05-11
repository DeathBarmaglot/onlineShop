package com.store.review;

import com.store.movie.entity.Review;

public interface ReviewService {

    Iterable<Review> getAllReviews();
}
