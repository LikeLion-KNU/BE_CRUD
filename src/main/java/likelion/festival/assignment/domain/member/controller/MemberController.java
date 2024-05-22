package likelion.festival.assignment.domain.member.controller;


import likelion.festival.assignment.domain.member.dto.request.MemberSaveRequest;
import likelion.festival.assignment.domain.member.dto.request.MemberUpdateRequest;
import likelion.festival.assignment.domain.member.dto.response.MemberAllReadResponse;
import likelion.festival.assignment.domain.member.dto.response.MemberIdReadResponse;
import likelion.festival.assignment.domain.member.service.MemberService;
import likelion.festival.assignment.global.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 생성
     */
    @PostMapping("/save")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> saveMember(
            @RequestBody MemberSaveRequest memberSaveRequest)
    {

        Long saveId = memberService.saveMember(memberSaveRequest);
        
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, saveId));
    }

    /**
     *  회원 전체 조회
     *  **/
    @GetMapping("/information/all")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<MemberAllReadResponse>>> getAllMember(){
        List<MemberAllReadResponse> allMember = memberService.getAllMember();
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, allMember));
    }


    /**
     * 회원 ID로 조회
     * **/
    @GetMapping("/information/{memberId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<MemberIdReadResponse>> getOneMember(
            @PathVariable("memberId") Long memberId
    )throws IOException {
        MemberIdReadResponse memberIdReadResponse = memberService.findOneMember(memberId);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, memberIdReadResponse));
    }
    /**
     * 회원 정보 수정
     * **/
    @PutMapping("/update/{memberId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> updateMember(
            @PathVariable("memberId")Long memberId,
            @RequestBody MemberUpdateRequest memberUpdateRequest) throws IOException {
        Long updateId = memberService.updateMember(memberUpdateRequest, memberId);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, updateId));
    }

    /**
     * 회원 ID로 삭제
     * **/
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<?>> deleteMember(
            @PathVariable("memberId") Long memberId
    ) throws IOException {
       memberService.deleteMember(memberId);
       return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK));
    }
}

