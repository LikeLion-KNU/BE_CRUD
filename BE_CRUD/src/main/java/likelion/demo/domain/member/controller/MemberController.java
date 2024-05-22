package likelion.demo.domain.member.controller;

import likelion.demo.domain.member.dto.request.MemberCreateRequest;
import likelion.demo.domain.member.dto.request.MemberUpdateRequest;
import likelion.demo.domain.member.dto.response.MemberReadResponse;
import likelion.demo.domain.member.entity.Member;
import likelion.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<Long> createMember(
            @RequestBody MemberCreateRequest memberCreateRequest
            )
    {
        Long memberId = memberService.createMember(memberCreateRequest);

        //return new ResponseEntity<>(memberId, HttpStatus.OK);
        return ResponseEntity.ok().body(memberId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberReadResponse>> findAll()
    {
        List<Member> all =memberService.findMemberAll();

        List<MemberReadResponse> allResposnse = MemberReadResponse.makeListMember(all);

        return ResponseEntity.ok().body(allResposnse);
    }

    @GetMapping("/find/{memberId}")
    public ResponseEntity<MemberReadResponse> find(
            @PathVariable("memberId") Long id
    ){
        Member member = memberService.findMemberById(id);

        MemberReadResponse memberReadResponse =MemberReadResponse
                .builder()
                .email(member.getEmail())
                .name(member.getName())
                .age(member.getAge())
                .build();

        return ResponseEntity.ok().body(memberReadResponse);
    }

    @PutMapping("/update/{memberId}")
    public ResponseEntity<String> update(
            @PathVariable("memberId") Long id,
            @RequestBody MemberUpdateRequest memberUpdateRequest
            )
    {
        String updatedMemberEmail = memberService.updateMember(memberUpdateRequest,id);

        return ResponseEntity.ok().body(updatedMemberEmail);

    }

    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<Long> delete(
            @PathVariable("memberId") Long id
    )
    {
        memberService.deleteMember(id);

        return ResponseEntity.ok().body(id);
    }


}
