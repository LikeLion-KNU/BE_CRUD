package com.example.BE_Homework.domain.member.service;

import com.example.BE_Homework.domain.member.dto.MemberReq;
import com.example.BE_Homework.domain.member.entity.Member;
import com.example.BE_Homework.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(MemberReq memberReq){
        Member member = Member.builder()
                .email(memberReq.email())
                .password(memberReq.password())
                .role(memberReq.role())
                .name(memberReq.name())
                .age(memberReq.age())
                .isAccountExpired(true)
                .isAccountLocked(false)
                .build();
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long memberId){
        return memberRepository.findById((memberId));
    }

    public void deleteMember(Long memberId){
        memberRepository.deleteById((memberId));
    }

    public Member updateMember(Member member){
        Member existMember = memberRepository.findById(member.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid Member Id"));

        existMember.setEmail(member.getEmail());
        existMember.setPassword(member.getPassword());
        existMember.setRole(member.getRole());
        existMember.setName(member.getName());
        existMember.setAge(member.getAge());
        existMember.setIsAccountLocked(member.getIsAccountLocked());
        existMember.setIsAccountExpired(member.getIsAccountExpired());

        return memberRepository.save(existMember);
    }
}
