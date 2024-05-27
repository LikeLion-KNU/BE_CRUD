package com.likelion.crud.repository;

import com.likelion.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

//    <회원>
//            회원 생성
//    회원 전체 조회
//        회원 ID로 조회
//        회원 정보 수정
//        회원 ID로 삭제