package com.example.crud.service;

import com.example.crud.dto.member.CreateMemberDto.CreateMemberRequest;
import com.example.crud.dto.member.CreateMemberDto.CreateMemberResponse;
import com.example.crud.dto.member.SimpleMemberDto;
import com.example.crud.dto.member.UpdateMemberDto.UpdateMemberRequest;
import com.example.crud.dto.member.UpdateMemberDto.UpdateMemberResponse;
import com.example.crud.entity.Member;
import com.example.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.crud.entity.enumType.Role.USER;
import static java.lang.Boolean.FALSE;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request){
        Member member = Member.builder()
                .age(request.getAge())
                .name(request.getName())
                .email(request.getEmail())
                .role(USER)
                .password(request.getPassword())
                .isAccountExpired(FALSE)
                .isAccountLocked(FALSE)
                .build();
        memberRepository.save(member);
        return CreateMemberResponse.toDto(member);
    }

    @Transactional
    public UpdateMemberResponse updateMember(UpdateMemberRequest request){
        Member member = findById(request.getMemberId());
        member.update(request.getEmail(),request.getName(), request.getPassword());
        return UpdateMemberResponse.toDto(member);
    }

    @Transactional
    public void deleteMember(Long memberId){
        memberRepository.deleteById(memberId);
    }

    public List<SimpleMemberDto> findAll()
    {
        return memberRepository.findAll()
                .stream()
                .map(SimpleMemberDto::toDto)
                .collect(Collectors.toList());
    }

    public SimpleMemberDto findMember(Long memberId){
        return SimpleMemberDto.toDto(findById(memberId));
    }

    public Member findById(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("No Such Member"));
    }

}
