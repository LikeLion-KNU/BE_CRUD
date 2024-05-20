package Assignment.crud.api;

import Assignment.crud.domain.Member;
import Assignment.crud.dto.MemberEditRequestDto;
import Assignment.crud.dto.MemberRequestDto;
import Assignment.crud.dto.MemberResponseDto;
import Assignment.crud.service.MemberService;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 생성
     */
    @PostMapping("/api/members")
    public ResponseEntity<?> addMember(@RequestBody @Validated MemberRequestDto memberRequestDto,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return returnErrors(bindingResult);
        }

        Member member = Member.builder()
                .name(memberRequestDto.getName())
                .password(memberRequestDto.getPassword())
                .age(memberRequestDto.getAge())
                .email(memberRequestDto.getEmail())
                .role(memberRequestDto.getRole())
                .isAccountExpired(memberRequestDto.getIsAccountExpired())
                .isAccountLocked(memberRequestDto.getIsAccountLocked())
                .build();

        Long newMemberId = memberService.join(member);

        return ResponseEntity.ok()
                .body(newMemberId);
    }

    /**
     * 회원 전체 조회
     */
    @GetMapping("/api/members")
    public ResponseEntity<?> findMembers() {

        List<MemberResponseDto> members = memberService.findAll()
                .stream()
                .map(MemberResponseDto::new)
                .toList();

        return ResponseEntity.ok()
                .body(members);
    }

    /**
     * 회원 ID로 조회
     */
    @GetMapping("/api/members/{id}")
    public ResponseEntity<?> findMemberById(@PathVariable(name = "id") Long id) {

        MemberResponseDto response = new MemberResponseDto(memberService.findById(id));

        return ResponseEntity.ok()
                .body(response);
    }

    /**
     * 회원 정보 수정
     */
    @PutMapping("/api/members/{id}")
    public ResponseEntity<?> editMember(@PathVariable(name = "id") Long id,
                                        @RequestBody @Validated MemberEditRequestDto member,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return returnErrors(bindingResult);
        }

        memberService.editMember(id, member);

        return ResponseEntity.ok()
                .body(id);
    }

    /**
     * 회원 ID로 삭제
     */
    @DeleteMapping("/api/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);

        return ResponseEntity.noContent().build();
    }


    private ResponseEntity<Map<String, String>> returnErrors(BindingResult bindingResult) {
        return ResponseEntity.badRequest()
                .body(bindingResult.getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
    }

}
