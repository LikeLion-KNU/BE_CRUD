package com.example.BE_Homework.controller;


import com.example.BE_Homework.dto.MemberReq;
import com.example.BE_Homework.entity.Member;
import com.example.BE_Homework.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    // 회원 생성
    @PostMapping
    public Member createMember(@RequestBody MemberReq memberReq){
        return memberService.createMember(memberReq);
    }
    // 회원 전체 조회
    @GetMapping
    public List<Member> findAllMembers(){
        return memberService.getAllMembers();
    }
    // 회원 ID로 조회
    @GetMapping("/{id}")
    public Optional<Member> findMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }
    // 회원 정보 수정
    @PutMapping
    public Member updateMember(@RequestBody Member member){
        return memberService.updateMember(member);
    }
    // 회원 ID로 삭제
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}
