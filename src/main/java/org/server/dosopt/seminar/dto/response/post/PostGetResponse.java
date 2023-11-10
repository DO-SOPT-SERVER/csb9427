package org.server.dosopt.seminar.dto.response.post;

import jdk.jfr.Category;
import org.server.dosopt.seminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content
        ) {
    public static PostGetResponse of(Post post) {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent()
                );
    }
}