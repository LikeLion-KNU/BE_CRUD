package com.likelion.crud.domain.member.repository;

import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.member.MemberPatchDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    List<Member> findAll();

    Optional<Member> findById(Long id);

    Member update(Long memberId, MemberPatchDto memberPatch);

    void deleteById(Long id);

}