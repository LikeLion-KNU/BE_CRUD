package likelion.demo.domain.coupon.service;

import jakarta.persistence.EntityNotFoundException;
import likelion.demo.domain.coupon.dto.request.CouponCreateRequest;
import likelion.demo.domain.coupon.dto.request.CouponUpdateRequest;
import likelion.demo.domain.coupon.entity.Coupon;
import likelion.demo.domain.coupon.repository.CouponRepository;
import likelion.demo.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {

    private final CouponRepository couponRepository;

    /**
     * 쿠폰 생성
     * @param couponCreateRequest
     * @return 쿠폰 아이디
     */

    @Transactional
    public Long createCoupon(CouponCreateRequest couponCreateRequest){
        Coupon coupon=Coupon.builder()
                .type(couponCreateRequest.type())
                .discount(couponCreateRequest.discount())
                .issueDate(couponCreateRequest.issueDate())
                .expirationDate(couponCreateRequest.expirationDate())
                .build();
        couponRepository.save(coupon);
        return coupon.getId();
    }

    /**
     * 쿠폰 삭제
     * @param id
     */
    @Transactional
    public void deleteCoupon(Long id){
        Coupon coupon=couponRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("쿠폰을 찾지 못했습니다."));
        couponRepository.delete(coupon);
    }

    /**
     *  쿠폰 정보 업데이트
     * @param couponUpdateRequest
     * @param id
     * @return 수정된 쿠폰 id
     */
    @Transactional
    public Long updateCoupon(CouponUpdateRequest couponUpdateRequest, Long id){
        Coupon coupon=couponRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("쿠폰을 찾지 못했습니다."));
        coupon.update(couponUpdateRequest);

        return coupon.getId();
    }

    public List<Coupon> allCoupon(){
        List<Coupon> coupons =couponRepository.findAll();

        return coupons;
    }

    public Coupon findCouponById(Long id){
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException( "쿠폰을 찾지 못했습니다"));
        return coupon;
    }




}
