package com.example.BE_Homework.domain.couponholders.repository;

import com.example.BE_Homework.domain.couponholders.entity.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponHoldersRepository extends JpaRepository<CouponHolders, Long> {
    List<CouponHolders> findCouponHoldersByMemberId(Long memberId);
    List<CouponHolders> findCouponHoldersByCouponId(Long couponId);

    void deleteByMemberIdAndCouponId(Long memberId, Long couponId);
}
