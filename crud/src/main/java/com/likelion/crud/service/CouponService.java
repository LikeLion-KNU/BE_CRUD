package com.likelion.crud.service;

import com.likelion.crud.dto.CouponRegisterDto;
import com.likelion.crud.dto.CouponUpdateDto;
import com.likelion.crud.entity.Coupon;
import com.likelion.crud.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {
    private CouponRepository couponRepository;
    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    //생성
    @Transactional
    public CouponRegisterDto.Response registerCoupon(CouponRegisterDto.Request couponRegisterDtoRequest) {
        Coupon coupon = Coupon.builder()
                .type(couponRegisterDtoRequest.getType())
                .discount(couponRegisterDtoRequest.getDiscount())
                .expirationDate(couponRegisterDtoRequest.getExpirationDate())
                .issueDate(LocalDateTime.now())
                .build();
        couponRepository.save(coupon);

        CouponRegisterDto.Response couponRegisterDtoResponse = new CouponRegisterDto.Response();
        couponRegisterDtoResponse.update(coupon);
        return couponRegisterDtoResponse;
    }

    //조회
    public List<Coupon> findCouponAll() {
        return couponRepository.findAll();
    }

    //정보 수정
    @Transactional
    public CouponUpdateDto.Response updateCoupon(Long couponId, CouponUpdateDto.Request couponUpdateDtoRequest) {
        Coupon subjectCoupon = couponRepository.findById(couponId).orElseThrow(() -> new IllegalArgumentException("해당 쿠폰이 없습니다."));
        subjectCoupon.update(couponUpdateDtoRequest);

        CouponUpdateDto.Response couponUpdateDtoResponse = new CouponUpdateDto.Response();
        couponUpdateDtoResponse.update(subjectCoupon);
        return couponUpdateDtoResponse;
    }

    //쿠폰 삭제
    public void deleteCoupon(Long couponId) {
        couponRepository.deleteById(couponId);
    }

}
