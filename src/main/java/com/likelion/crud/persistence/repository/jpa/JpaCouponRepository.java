package com.likelion.crud.persistence.repository.jpa;

import com.likelion.crud.persistence.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCouponRepository extends JpaRepository<CouponEntity, Long> {
}
