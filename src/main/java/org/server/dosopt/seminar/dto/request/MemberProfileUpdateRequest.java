package org.server.dosopt.seminar.dto.request;

import org.server.dosopt.seminar.domain.Part;

public record MemberProfileUpdateRequest(
        int generation,
        Part part) {
}