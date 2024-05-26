package com.likelion.crud.domain.coupon.repository;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.coupon.CouponPatchDto;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {

    Coupon save(Coupon coupon);

    Optional<Coupon> findById(Long id);

    List<Coupon> findAll();

    Coupon update(Long couponId, CouponPatchDto couponPatch);

    void deleteById(Long id);

}
