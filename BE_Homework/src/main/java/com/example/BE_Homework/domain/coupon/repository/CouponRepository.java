package com.example.BE_Homework.domain.coupon.repository;

import com.example.BE_Homework.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository <- 안해도 됨
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    void deleteCouponById(Long id);
}
