package com.likelion.crud.domain.coupon.repository;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.Member;

import java.util.List;

public interface CouponHolderRepository {

    List<Coupon> findAllCouponByMemberId(Long memberId);

    List<Member> findAllMember();

    List<Member> findAllMemberByCouponId(Long couponId);

    void save(Member member, Coupon coupon);

    void deleteAllByMemberId(Long memberId);

}