package com.LikeLion.CRUD.repository.coupon;

import com.LikeLion.CRUD.entity.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
