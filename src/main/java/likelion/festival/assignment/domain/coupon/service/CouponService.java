package likelion.festival.assignment.domain.coupon.service;

import likelion.festival.assignment.domain.coupon.dto.request.CouponSaveRequest;
import likelion.festival.assignment.domain.coupon.dto.request.CouponUpdateRequest;
import likelion.festival.assignment.domain.coupon.dto.response.CouponAllReadResponse;
import likelion.festival.assignment.domain.coupon.entity.Coupon;
import likelion.festival.assignment.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {

    CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Long saveCoupon(CouponSaveRequest couponSaveRequest){
        Coupon coupon = Coupon.builder()
                .type(couponSaveRequest.type())
                .discount(couponSaveRequest.discount())
                .expiration_time(couponSaveRequest.expiration_time())
                .issue_time((couponSaveRequest.issue_time()))
                .build();

        couponRepository.save(coupon);

        return coupon.getId();
    }

    public List<CouponAllReadResponse> getAllCoupon(){
        try{
            List<Coupon> couponList = couponRepository.findAll();
            List<CouponAllReadResponse> responseList = new ArrayList<>();

            for(Coupon coupon: couponList){
                responseList.add(
                        new CouponAllReadResponse(coupon.getId(), coupon.getType(), coupon.getDiscount(), coupon.getIssue_time(), coupon.getExpiration_time())
                );
            }
            return responseList;
        }catch(Exception e){
        }
        return null;
    }

    @Transactional
    public Long updateCoupon(CouponUpdateRequest couponUpdateRequest, Long couponId)throws IOException {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow();
        coupon.updateCoupon(couponUpdateRequest);

        return coupon.getId();
    }

    @Transactional
    public void deleteCoupon(Long couponId)throws IOException{
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow();
        couponRepository.delete(coupon);
    }
}
