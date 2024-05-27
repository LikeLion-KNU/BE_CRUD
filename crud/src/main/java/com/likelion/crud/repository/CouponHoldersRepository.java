package com.likelion.crud.repository;

import com.likelion.crud.entity.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CouponHoldersRepository extends JpaRepository<CouponHolders, Long> {
    List<CouponHolders> findByMemberId(Long memberId);
    List<CouponHolders> findByCouponId(Long couponId);
    void deleteByMemberIdAndCouponId(Long memberId, Long couponId);
}
