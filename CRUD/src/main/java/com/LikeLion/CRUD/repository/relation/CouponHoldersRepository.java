package com.LikeLion.CRUD.repository.relation;

import com.LikeLion.CRUD.entity.relation.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponHoldersRepository extends JpaRepository<CouponHolders, Long> {
    List<CouponHolders> findAllByMemberId(Long memberId);
    List<CouponHolders> findAllByCouponId(Long couponId);
    void deleteByMemberIdAndCouponId(Long memberId, Long couponId);
}

