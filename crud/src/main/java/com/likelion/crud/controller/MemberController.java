package com.likelion.crud.controller;

import com.likelion.crud.dto.MemberRegisterDto;
import com.likelion.crud.dto.MemberUpdateDto;
import com.likelion.crud.entity.Member;
import com.likelion.crud.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원 생성
    @PostMapping("/memberCreate")
    public MemberRegisterDto.Response registerMember(@RequestBody MemberRegisterDto.Request memberRegisterDtoRequest) {
        return memberService.registerMember(memberRegisterDtoRequest);
    }

    //회원 전체
    @GetMapping("/memberGetAll")
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    //회원 아이디 조회
    @GetMapping("/member/get/{id}")
    public Member findMember(@PathVariable("id") Long id) {
        Optional<Member> member = memberService.getMemberById(id);
        return member.orElseThrow();
    }

    //수정
    @PutMapping("/member/edit/{id}")
    public MemberUpdateDto.Response editMember(@PathVariable("id") Long id, @RequestBody MemberUpdateDto.Request memberUpdateDtoRequest) {
        return memberService.editMemberInfo(id, memberUpdateDtoRequest);
    }

    //삭제
    @DeleteMapping("/member/delete/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }

}
//    <회원>
//            회원 생성
//    회원 전체 조회
//        회원 ID로 조회
//        회원 정보 수정
//        회원 ID로 삭제
