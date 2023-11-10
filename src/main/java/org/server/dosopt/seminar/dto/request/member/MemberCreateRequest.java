package org.server.dosopt.seminar.dto.request.member;

import org.server.dosopt.seminar.domain.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}