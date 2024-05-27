package com.likelion.crud.service;

import com.likelion.crud.dto.MemberRegisterDto;
import com.likelion.crud.dto.MemberUpdateDto;
import com.likelion.crud.entity.Member;
import com.likelion.crud.entity.Role;
import com.likelion.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //전체 조회
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    //아이디 조회
    public Optional<Member> getMemberById(Long Id) {
        return memberRepository.findById(Id);
    }

    //생성
    @Transactional
    public MemberRegisterDto.Response registerMember(MemberRegisterDto.Request memberRegisterDtoRequest)
    {
        Member member = Member.builder()
                .name(memberRegisterDtoRequest.getName())
                .age(memberRegisterDtoRequest.getAge())
                .email(memberRegisterDtoRequest.getEmail())
                .password(memberRegisterDtoRequest.getPassword())
                .role(Role.User)
                .isAccountExpired(false)
                .isAccountLocked(false)
                .build();
        memberRepository.save(member);

        MemberRegisterDto.Response memberRegisterDtoResponse = new MemberRegisterDto.Response();
        memberRegisterDtoResponse.update(member);
        return memberRegisterDtoResponse;
    }

    //삭제
    public void deleteMember(Long Id) {
        memberRepository.deleteById(Id);
    }

    //수정
    @Transactional
    public MemberUpdateDto.Response editMemberInfo(Long Id, MemberUpdateDto.Request memberUpdateDtoRequest) {
        Member subjectMember = memberRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        subjectMember.update(memberUpdateDtoRequest);
        MemberUpdateDto.Response memberUpdateDtoResponse = new MemberUpdateDto.Response();
        memberUpdateDtoResponse.update(subjectMember);
        return memberUpdateDtoResponse;
    }

}

//    <회원>
//        회원 생성
//        회원 전체 조회
//        회원 ID로 조회
//        회원 정보 수정
//        회원 ID로 삭제