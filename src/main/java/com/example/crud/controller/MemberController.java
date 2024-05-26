package com.example.crud.controller;

import com.example.crud.dto.member.CreateMemberDto;
import com.example.crud.dto.member.CreateMemberDto.CreateMemberRequest;
import com.example.crud.dto.member.CreateMemberDto.CreateMemberResponse;
import com.example.crud.dto.member.SimpleMemberDto;
import com.example.crud.dto.member.UpdateMemberDto;
import com.example.crud.dto.member.UpdateMemberDto.UpdateMemberRequest;
import com.example.crud.dto.member.UpdateMemberDto.UpdateMemberResponse;
import com.example.crud.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<CreateMemberResponse> createMember(@RequestBody CreateMemberRequest request){
        return ResponseEntity
                .status(CREATED)
                .body(memberService.createMember(request));
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateMemberResponse> updateMember(@RequestBody UpdateMemberRequest request){
        return ResponseEntity
                .status(OK)
                .body(memberService.updateMember(request));
    }

    @PostMapping("/delete/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity
                .status(NO_CONTENT)
                .body(null);
    }

    @GetMapping("/user/{memberId}")
    public ResponseEntity<SimpleMemberDto> findMember(@PathVariable("memberId") Long memberId){
        return ResponseEntity
                .status(OK)
                .body(memberService.findMember(memberId));
    }

    @GetMapping("/users")
    public ResponseEntity<List<SimpleMemberDto>> showAll(){
        return ResponseEntity
                .status(OK)
                .body(memberService.findAll());
    }

}
