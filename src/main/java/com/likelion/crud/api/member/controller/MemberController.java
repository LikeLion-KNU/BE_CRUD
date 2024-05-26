package com.likelion.crud.api.member.controller;

import com.likelion.crud.api.member.CreateMemberRequestMapper;
import com.likelion.crud.api.member.UpdateMemberRequestMapper;
import com.likelion.crud.api.member.dto.request.CreateMemberRequest;
import com.likelion.crud.api.member.dto.request.UpdateMemberRequest;
import com.likelion.crud.api.member.dto.response.CreateMemberResponse;
import com.likelion.crud.api.member.dto.response.MemberResponse;
import com.likelion.crud.api.member.dto.response.UpdateMemberResponse;
import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final CreateMemberRequestMapper createRequestMapper;
    private final UpdateMemberRequestMapper updateRequestMapper;

    @PostMapping("/member")
    public ResponseEntity<CreateMemberResponse> createMember(
            @RequestBody CreateMemberRequest request
    ) {
        Member member = memberService.create(createRequestMapper.map(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CreateMemberResponse.of(member));
    }

    @GetMapping("/member")
    public ResponseEntity<List<MemberResponse>> findMembers(
            @RequestParam(required = false, name = "has-coupon") Boolean hasCoupon,
            @RequestParam(required = false, name = "coupon-id") Long couponId
    ) {
        validateFindRequestParam(hasCoupon, couponId);
        if (hasCoupon == null) {
            return ResponseEntity.ok(convert(memberService.findAll()));
        }
        if (couponId != null) {
            return ResponseEntity.ok(convert(memberService.findAllByCoupon(couponId)));
        }
        return ResponseEntity.ok(convert(memberService.findAllByCoupon()));
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        Member member = memberService.getById(id);
        return ResponseEntity.ok(MemberResponse.of(member));
    }

    @PatchMapping("/member/{id}")
    public ResponseEntity<UpdateMemberResponse> updateMember(
            @PathVariable Long id,
            @RequestBody UpdateMemberRequest request
    ) {
        Member member = memberService.update(id, updateRequestMapper.map(request));
        return ResponseEntity.ok(UpdateMemberResponse.of(member));
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void validateFindRequestParam(
            Boolean hasCoupon,
            Long couponId
    ) {
        if ((hasCoupon == null || !hasCoupon) && couponId != null) {
            throw new IllegalArgumentException();
        }
    }

    private static List<MemberResponse> convert(List<Member> members) {
        return members.stream().map(MemberResponse::of).toList();
    }
}
