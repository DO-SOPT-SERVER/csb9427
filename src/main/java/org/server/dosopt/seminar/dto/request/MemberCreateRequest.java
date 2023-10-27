package org.server.dosopt.seminar.dto.request;

import org.server.dosopt.seminar.domain.SOPT;
import lombok.Data;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
}