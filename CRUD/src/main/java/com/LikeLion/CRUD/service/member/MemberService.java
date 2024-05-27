package com.LikeLion.CRUD.service.member;

import com.LikeLion.CRUD.dto.member.MemberCreateDTO;
import com.LikeLion.CRUD.dto.member.MemberInfoDTO;
import com.LikeLion.CRUD.entity.member.Member;
import com.LikeLion.CRUD.exception.member.MemberNotFoundException;
import com.LikeLion.CRUD.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 수정 전 회원 생성
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // 회원 생성 DTO 사용 버전
    public Member createMemberFromDto(MemberCreateDTO memberCreateDTO) {
        Member member = new Member();
        member.setEmail(memberCreateDTO.getEmail());
        member.setPassword(memberCreateDTO.getPassword());
        member.setRole(memberCreateDTO.getRole());
        member.setName(memberCreateDTO.getName());
        member.setAge(memberCreateDTO.getAge());
        member.setIsAccountExpired(memberCreateDTO.getIsAccountExpired());
        member.setIsAccountLocked(memberCreateDTO.getIsAccountLocked());

        return memberRepository.save(member);
    }

    // 수정 전 회원 전체 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // MemberService 내에 엔티티 리스트를 DTO 리스트로 변환하는 메소드 추가
    public List<MemberInfoDTO> getAllMembersAsDto() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(member -> {
                    MemberInfoDTO dto = new MemberInfoDTO();
                    dto.setEmail(member.getEmail());
                    dto.setRole(member.getRole());
                    dto.setName(member.getName());
                    dto.setAge(member.getAge());
                    dto.setIsAccountExpired(member.getIsAccountExpired());
                    dto.setIsAccountLocked(member.getIsAccountLocked());
                    return dto;
        }).collect(Collectors.toList());
    }

    // 수정 전 회원 ID로 조회
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member with ID " + id + " not found"));
    }

    // 회원 ID 조회 DTO 사용해서 수정
    public MemberInfoDTO getMemberByIdAsDto(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member not found with id " + id));
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
        memberInfoDTO.setEmail(member.getEmail());
        memberInfoDTO.setRole(member.getRole());
        memberInfoDTO.setName(member.getName());
        memberInfoDTO.setAge(member.getAge());
        memberInfoDTO.setIsAccountExpired(member.getIsAccountExpired());
        memberInfoDTO.setIsAccountLocked(member.getIsAccountLocked());
        return memberInfoDTO;
    }


    // 수정 전 회원 정보 수정
/*    public Member updateMember(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member with ID " + id + " not found"));

        member.setEmail(memberDetails.getEmail());
        member.setPassword(memberDetails.getPassword());
        member.setRole(memberDetails.getRole());
        member.setName(memberDetails.getName());
        member.setAge(memberDetails.getAge());
        member.setIsAccountExpired(memberDetails.getIsAccountExpired());
        member.setIsAccountLocked(memberDetails.getIsAccountLocked());

        return memberRepository.save(member);
    }*/

    public MemberInfoDTO updateMember(Long id, MemberInfoDTO memberInfoDTO) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member not found with id " + id));

        member.setEmail(memberInfoDTO.getEmail());
        member.setRole(memberInfoDTO.getRole());
        member.setName(memberInfoDTO.getName());
        member.setAge(memberInfoDTO.getAge());
        member.setIsAccountExpired(memberInfoDTO.getIsAccountExpired());
        member.setIsAccountLocked(memberInfoDTO.getIsAccountLocked());

        Member updatedMember = memberRepository.save(member);

        return getMemberByIdAsDto(updatedMember.getId()); // 재사용
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

