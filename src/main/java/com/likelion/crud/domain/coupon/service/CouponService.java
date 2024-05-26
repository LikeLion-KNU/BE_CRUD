package com.likelion.crud.domain.coupon.service;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.coupon.CouponPatchDto;
import com.likelion.crud.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public Coupon create(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Coupon getById(Long id) {
        return couponRepository.findById(id).orElseThrow();
    }

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    public Coupon update(Long couponId, CouponPatchDto couponPatch) {
        return couponRepository.update(couponId, couponPatch);
    }


    public void deleteById(Long id) {
        couponRepository.deleteById(id);
    }
}
