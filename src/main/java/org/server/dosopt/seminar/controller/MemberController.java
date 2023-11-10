package org.server.dosopt.seminar.controller;

import org.server.dosopt.seminar.dto.request.member.MemberCreateRequest;
import org.server.dosopt.seminar.dto.request.member.MemberProfileUpdateRequest;
import org.server.dosopt.seminar.dto.response.member.MemberGetResponse;
import org.server.dosopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable("id") Long memberId) {
        return createResponse(memberService.getMemberByIdV1(memberId));
    }

    @GetMapping(value = "/{memberId}/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return createResponse(memberService.getMemberByIdV2(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return createResponse(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location = URI.create("api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();
        //return ResponseEntity.status(HttpStatus.CREATED)
        //        .body()
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
        memberService.updateSOPT(memberId, request);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    private <T> ResponseEntity<T> createResponse(T body) {
        return ResponseEntity.ok(body);
    }
}