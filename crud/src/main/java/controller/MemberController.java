package controller;

import domain.Member;
import dto.member.MemberRegisterRequestDTO;
import dto.member.MemberRegisterResponseDTO;
import dto.member.MemberUpdateRequestDTO;
import Service.MemberService;
import dto.member.MemberUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    /*
    회원 생성
     */
    public MemberRegisterResponseDTO registerMember(@RequestBody MemberRegisterRequestDTO memberRegisterRequestDTO) {
        return memberService.registerMember(memberRegisterRequestDTO);
    }
    /*
    회원 전체 조회
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Member> findAllMembers(){
        return memberService.findAllMembers();
    }
    /*
    회원 ID로 조회
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Member findMember(@PathVariable Long id){
        Optional<Member> member = memberService.findMember(id);
        return member.orElseThrow();
    }
    /*
    회원 정보 수정
     */
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MemberUpdateResponseDTO editMember(@PathVariable Long id, @RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO){
        return memberService.editMember(id, memberUpdateRequestDTO);
    }
    /*
    회원 ID로 삭제
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}
