package likelion.demo.domain.coupon.controller;

import likelion.demo.domain.coupon.dto.request.CouponCreateRequest;
import likelion.demo.domain.coupon.dto.request.CouponUpdateRequest;
import likelion.demo.domain.coupon.dto.response.CouponReadResponse;
import likelion.demo.domain.coupon.entity.Coupon;
import likelion.demo.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/create")
    public ResponseEntity<Long> create(
            @RequestBody CouponCreateRequest couponCreateRequest
            )
    {
        Long couponId = couponService.createCoupon(couponCreateRequest);

        return ResponseEntity.ok().body(couponId);
    }

    @PutMapping("/update/{couponId}")
    public ResponseEntity<Long> update(
            @PathVariable("couponId") Long id,
            @RequestBody CouponUpdateRequest couponUpdateRequest
            )
    {
        Long couponId = couponService.updateCoupon(couponUpdateRequest, id);

        return ResponseEntity.ok().body(couponId);

    }

    @DeleteMapping("/delete/{couponId}")
    public ResponseEntity<Long> delete(
    @PathVariable("couponId") Long id
            )
    {
        couponService.deleteCoupon(id);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CouponReadResponse>> all(){
        List<Coupon> coupons = couponService.allCoupon();

        List<CouponReadResponse> couponReadResponses =CouponReadResponse.makeListCoupon(coupons);
        return ResponseEntity.ok().body(couponReadResponses);
    }




}
