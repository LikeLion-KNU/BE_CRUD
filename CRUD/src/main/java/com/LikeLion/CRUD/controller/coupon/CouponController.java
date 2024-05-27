package com.LikeLion.CRUD.controller.coupon;

import com.LikeLion.CRUD.dto.coupon.CouponDTO;
import com.LikeLion.CRUD.entity.coupon.Coupon;
import com.LikeLion.CRUD.exception.coupon.CouponNotFoundException;
import com.LikeLion.CRUD.service.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    // 쿠폰 생성
    @PostMapping
    public Coupon createCoupon(@RequestBody CouponDTO couponDTO) {
        Coupon coupon = convertToEntity(couponDTO);
        return couponService.createCoupon(coupon);
    }

    // CouponDTO를 Coupon 엔티티로 변환하는 메서드
    private Coupon convertToEntity(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        coupon.setType(couponDTO.getType());
        coupon.setDiscount(couponDTO.getDiscount());
        coupon.setIssueDate(couponDTO.getIssueDate());
        coupon.setExpirationDate(couponDTO.getExpirationDate());
        return coupon;
    }

    // 모든 쿠폰 조회
    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    // 쿠폰 정보 수정
    @PutMapping("/{id}")
    public Coupon updateCoupon(@PathVariable Long id, @RequestBody Coupon couponDetails) {
        return couponService.updateCoupon(id, couponDetails);
    }

    // 쿠폰 삭제
    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }

    // 예외처리 CouponNotFoundException
    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<String> handleCouponNotFoundException(CouponNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
