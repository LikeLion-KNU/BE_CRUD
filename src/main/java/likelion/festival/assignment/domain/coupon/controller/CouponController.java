package likelion.festival.assignment.domain.coupon.controller;

import likelion.festival.assignment.domain.coupon.dto.request.CouponSaveRequest;
import likelion.festival.assignment.domain.coupon.dto.request.CouponUpdateRequest;
import likelion.festival.assignment.domain.coupon.dto.response.CouponAllReadResponse;
import likelion.festival.assignment.domain.coupon.entity.Coupon;
import likelion.festival.assignment.domain.coupon.service.CouponService;
import likelion.festival.assignment.global.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("coupon")
public class CouponController {
    CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    /**
     * 쿠폰 생성
     * **/
    @PostMapping("/save")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> saveCoupon(
            @RequestBody CouponSaveRequest couponSaveRequest)
    {

        Long saveId = couponService.saveCoupon(couponSaveRequest);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, saveId));
    }

    /**
     * 모든 쿠폰 조회
     * **/
    @GetMapping("/information/all")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<CouponAllReadResponse>>> getAllCoupon(){
        List<CouponAllReadResponse> responseList = couponService.getAllCoupon();
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, responseList));
    }
    /**
     * 쿠폰 정보 수정
     * **/
    @PutMapping("/update/{couponId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> updateCoupon(
            @PathVariable("couponId")Long couponId,
            @RequestBody()CouponUpdateRequest couponUpdateRequest
            ) throws IOException {
        Long updateId = couponService.updateCoupon(couponUpdateRequest, couponId);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, updateId));
    }

    /**
     * 쿠폰 삭제
     * **/
    @DeleteMapping("/delete/{couponId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<?>>deleteCoupon(
            @PathVariable("couponId") Long couponId
    ) throws IOException {
        couponService.deleteCoupon(couponId);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK));
    }


}
