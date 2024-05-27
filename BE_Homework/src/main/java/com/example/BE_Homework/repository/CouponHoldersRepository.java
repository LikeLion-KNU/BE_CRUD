package com.example.BE_Homework.repository;

import com.example.BE_Homework.entity.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponHoldersRepository extends JpaRepository<CouponHolders, Long> {
    List<CouponHolders> findHoldersByMemberId(Long memberId);
    List<CouponHolders> findHoldersByCouponId(Long couponId);

    void deleteMemberIdAndCouponId(Long memberId, Long couponId);
}
