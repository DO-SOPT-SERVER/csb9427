package org.server.dosopt.seminar.controller;

import org.server.dosopt.seminar.dto.request.MemberCreateRequest;
import org.server.dosopt.seminar.dto.request.MemberProfileUpdateRequest;
import org.server.dosopt.seminar.dto.response.MemberGetResponse;
import org.server.dosopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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

    @GetMapping("{id}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable("id") Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV1(memberId));
    }

    @GetMapping(value = "{memberId}/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV2(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location = URI.create("api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();
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
}