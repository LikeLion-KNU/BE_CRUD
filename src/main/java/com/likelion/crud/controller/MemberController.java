package com.likelion.crud.controller;


import com.likelion.crud.dto.MemberCreateReq;
import com.likelion.crud.entity.Member;
import com.likelion.crud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public Member createMember(@RequestBody MemberCreateReq memberCreateReq) {
        return memberService.createMember(memberCreateReq);
    }

    @GetMapping()
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PutMapping()
    public Member updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

}
