package com.likelion.crud.repository;


import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.CouponHolder;
import com.likelion.crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponHolderRepository extends JpaRepository<CouponHolder, Long> {

    List<CouponHolder> findByMember(Member member);

    List<CouponHolder> findByCoupon(Coupon coupon);

    Optional<CouponHolder> findByMemberAndCoupon(Member member, Coupon coupon);
}
