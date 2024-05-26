package com.likelion.crud.api.coupon;

import com.likelion.crud.api.coupon.dto.request.CreateCouponRequest;
import com.likelion.crud.domain.Coupon;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateCouponRequestMapper {

    public Coupon map(CreateCouponRequest request) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationDate = now.plusMonths(request.expiration());
        return new Coupon(
                null,
                request.couponType(),
                request.discount(),
                now,
                expirationDate
        );
    }
}
