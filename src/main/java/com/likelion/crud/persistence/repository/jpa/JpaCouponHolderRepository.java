package com.likelion.crud.persistence.repository.jpa;

import com.likelion.crud.persistence.entity.CouponHoldersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCouponHolderRepository extends JpaRepository<CouponHoldersEntity, Long> {

    List<CouponHoldersEntity> findAllByMember_MemberId(Long memberId);

    List<CouponHoldersEntity> findAllByCoupon_CouponId(Long couponId);

    void deleteAllByMember_MemberId(Long memberId);

}
