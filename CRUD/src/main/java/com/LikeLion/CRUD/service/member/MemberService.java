package com.LikeLion.CRUD.service.member;

import com.LikeLion.CRUD.entity.member.Member;
import com.LikeLion.CRUD.exception.member.MemberNotFoundException;
import com.LikeLion.CRUD.repository.member.MemberRepository;
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

    // 회원 생성
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // 회원 전체 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 회원 ID로 조회
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member with ID " + id + " not found"));
    }

    // 회원 정보 수정
    public Member updateMember(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member with ID " + id + " not found"));

        member.setEmail(memberDetails.getEmail());
        member.setPassword(memberDetails.getPassword());
        member.setRole(memberDetails.getRole());
        member.setName(memberDetails.getName());
        member.setAge(memberDetails.getAge());
        member.setIsAccountExpired(memberDetails.getIsAccountExpired());
        member.setIsAccountLocked(memberDetails.getIsAccountLocked());

        return memberRepository.save(member);
    }

    // 회원 ID로 삭제
    public void deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new MemberNotFoundException("Member with ID " + id + " not found");
        }
    }
}

