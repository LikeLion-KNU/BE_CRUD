package com.LikeLion.CRUD.repository.member;

import com.LikeLion.CRUD.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member,Long> {
}
