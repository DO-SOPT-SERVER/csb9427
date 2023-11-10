package org.server.dosopt.seminar.dto.response.member;

import org.server.dosopt.seminar.domain.Member;
import org.server.dosopt.seminar.domain.SOPT;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}