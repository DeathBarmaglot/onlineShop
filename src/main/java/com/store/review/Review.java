package com.store.review;

import com.store.movie.domain.Movie;
import com.store.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "review")
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long reviewId;

    @Column(name = "text", length = 1024)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private String nickname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId.equals(review.reviewId) && text.equals(review.text) && movie.equals(review.movie) && nickname.equals(review.nickname);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", text='" + text + '\'' +
                ", movie=" + movie.getNameOrigin() +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
