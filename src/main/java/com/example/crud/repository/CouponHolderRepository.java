package com.example.crud.repository;

import com.example.crud.entity.CouponHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CouponHolderRepository extends JpaRepository<CouponHolder,Long> {
    Optional<List<CouponHolder>> findCouponsByMemberId(Long memberId);
    Optional<List<CouponHolder>> findCouponHolderByCouponId(Long couponId);
}
