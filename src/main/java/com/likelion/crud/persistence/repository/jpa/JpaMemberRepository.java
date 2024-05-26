package com.likelion.crud.persistence.repository.jpa;

import com.likelion.crud.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<MemberEntity, Long> {
}
