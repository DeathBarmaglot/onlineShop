package com.store.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class RequestProps {

    private SortDirection rating;
    private SortDirection price;
    private SortDirection id;
    private SortField field;

    public List<Order> getOrder() {
        List<Order> orders = new ArrayList<>();
        Sort.Direction asc = Sort.Direction.ASC;
        Sort.Direction desc = Sort.Direction.DESC;

        try {
            String priceValue = price.getValue().toUpperCase();
            if (!asc.name().equalsIgnoreCase(priceValue)) {
                orders.add(new Order(desc, SortField.PRICE.getValue()));
            }
        } catch (NullPointerException nullPointerException) {
            orders.add(new Order(asc, SortField.PRICE.getValue()));
        }

        try {
            String ratingValue = rating.getValue().toUpperCase();
            if (!asc.name().equalsIgnoreCase(ratingValue)) {
                orders.add(new Order(desc, SortField.RATING.getValue()));
            }
        } catch (NullPointerException nullPointerException) {
            orders.add(new Order(asc, SortField.MOVIE_ID.getValue()));
        }
        return orders;
    }

    @Getter
    public enum SortField {
        MOVIE_ID("movieId"), RATING("rating"), PRICE("price");

        private final String value;

        SortField(String value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", rating=" + rating + ", price=" + price + '}';
    }
}
