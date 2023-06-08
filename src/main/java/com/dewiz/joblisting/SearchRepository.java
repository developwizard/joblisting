package com.dewiz.joblisting;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchRepository {
    List<Post> findByText(String text);
}
