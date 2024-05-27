package com.likelion.crud.repository;

import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
