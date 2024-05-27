package com.example.BE_Homework.service;

import com.example.BE_Homework.dto.CouponReq;
import com.example.BE_Homework.entity.Coupon;
import com.example.BE_Homework.repository.CouponHoldersRepository;
import com.example.BE_Homework.repository.CouponRepository;
import com.example.BE_Homework.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;
    private final CouponHoldersRepository couponHoldersRepository;

    public Coupon createCoupon(CouponReq couponReq){
        Coupon coupon = Coupon.builder()
                .type(couponReq.couponType())
                .discount(couponReq.discount())
                .issueDate(LocalDateTime.now())
                .expirationDate(couponReq.expirationDate())
                .build();
        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    public void deleteCoupon(Long id){
        couponRepository.deleteById(id);
    }
}
