package com.likelion.crud.domain.coupon.service;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.coupon.repository.CouponHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponHolderService {

    private final CouponHolderRepository couponRepository;

    public void allocateCouponToMember(Member member, Coupon coupon) {
        couponRepository.save(member, coupon);
    }

    public List<Coupon> findAllCouponByMemberId(Long memberId) {
        return couponRepository.findAllCouponByMemberId(memberId);
    }

    public void deleteAllCouponFromMember(Long memberId) {
        couponRepository.deleteAllByMemberId(memberId);
    }

}
