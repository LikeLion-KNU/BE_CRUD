package com.likelion.crud.api.coupon;

import com.likelion.crud.api.coupon.dto.request.UpdateCouponRequest;
import com.likelion.crud.domain.coupon.CouponPatchDto;
import org.springframework.stereotype.Component;

@Component
public class UpdateCouponRequestMapper {

    public CouponPatchDto map(UpdateCouponRequest request) {
        return new CouponPatchDto(
                request.couponType(),
                request.discount()
        );
    }
}
