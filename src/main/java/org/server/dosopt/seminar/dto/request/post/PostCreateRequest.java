package org.server.dosopt.seminar.dto.request.post;

public record PostCreateRequest(
        String title,
        String content
) {
}