package com.likelion.crud.service;

import com.likelion.crud.dto.MemberCreateReq;
import com.likelion.crud.entity.Member;
import com.likelion.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(MemberCreateReq memberCreateReq) {

        Member member = Member.builder()
                .email(memberCreateReq.email())
                .password(memberCreateReq.password())
                .role(memberCreateReq.role())
                .name(memberCreateReq.name())
                .age(memberCreateReq.age())
                .isAccountExpired(false)
                .isAccountLocked(false)
                .build();

        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member updateMember(Member member) {

        Member findMember = memberRepository.findById(member.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        findMember.setEmail(member.getEmail());
        findMember.setPassword(member.getPassword());
        findMember.setRole(member.getRole());
        findMember.setName(member.getName());
        findMember.setAge(member.getAge());
        findMember.setAccountExpired(member.getIsAccountExpired());
        findMember.setAccountLocked(member.getIsAccountLocked());

        return memberRepository.save(findMember);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
