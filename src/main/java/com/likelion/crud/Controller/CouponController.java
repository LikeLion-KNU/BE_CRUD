package com.likelion.crud.Controller;

import com.likelion.crud.Entity.Coupon;
import com.likelion.crud.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/coupons")
    public Coupon newCoupon(@RequestBody Coupon coupon){
        return couponService.addCoupon(coupon);
    }

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons(){
        return couponService.getAllCoupons();
    }

    @PutMapping("/coupon")
    public Optional<Coupon> editCoupon(@RequestParam("id") Long id, @RequestBody Coupon target){
        return couponService.editCoupon(id,target.getType(),target.getDiscount(),target.getIssue_date(),target.getExpiration_date());
    }

    @DeleteMapping("coupon")
    public List<Coupon> removeCoupon(@RequestParam("id") Long id){
        return couponService.removeCoupon(id);
    }


}
