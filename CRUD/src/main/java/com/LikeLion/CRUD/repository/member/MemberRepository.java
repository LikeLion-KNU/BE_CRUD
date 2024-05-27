package com.LikeLion.CRUD.repository.member;

import com.LikeLion.CRUD.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository <Member,Long> {
}
