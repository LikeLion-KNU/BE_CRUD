package com.LikeLion.CRUD.controller.member;

import com.LikeLion.CRUD.dto.member.MemberCreateDTO;
import com.LikeLion.CRUD.dto.member.MemberInfoDTO;
import com.LikeLion.CRUD.entity.member.Member;
import com.LikeLion.CRUD.exception.member.MemberNotFoundException;
import com.LikeLion.CRUD.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 생성 -> 나중에 DTO 만들어서 id 안받아도되게 수정해보기 까먹지 말자
    // 수정완~
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberCreateDTO memberCreateDTO) {
        Member createdMember = memberService.createMemberFromDto(memberCreateDTO);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    // 회원 전체 조회 -> DTO 사용하는 것으로 바꿈
    @GetMapping
    public ResponseEntity<List<MemberInfoDTO>> getAllMembers() {
        List<MemberInfoDTO> membersDto = memberService.getAllMembersAsDto();
        return new ResponseEntity<>(membersDto, HttpStatus.OK);
    }

    // 회원 ID로 조회-> DTO 사용하는 것으로 바꿈
    @GetMapping("/{id}")
    public ResponseEntity<MemberInfoDTO> getMemberById(@PathVariable Long id) {
        MemberInfoDTO memberInfoDTO = memberService.getMemberByIdAsDto(id);
        return new ResponseEntity<>(memberInfoDTO, HttpStatus.OK);
    }

    // 회원 정보 수정 : 누가 수정하는 것일까 회원이? 관리자가? -> DTO 사용하는 것으로 바꿈
    @PutMapping("/{id}")
    public ResponseEntity<MemberInfoDTO> updateMember(@PathVariable Long id, @RequestBody MemberInfoDTO memberInfoDTO) {
        MemberInfoDTO updatedMemberInfoDTO = memberService.updateMember(id, memberInfoDTO);
        return new ResponseEntity<>(updatedMemberInfoDTO, HttpStatus.OK);
    }


    // 회원 ID로 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // MemberNotFoundException 예외 처리
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<String> handleMemberNotFoundException(MemberNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
