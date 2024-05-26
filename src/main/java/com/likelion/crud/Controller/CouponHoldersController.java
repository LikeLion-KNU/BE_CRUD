package com.likelion.crud.Controller;

import com.likelion.crud.Entity.Coupon;
import com.likelion.crud.Entity.CouponHolders;
import com.likelion.crud.Entity.Member;
import com.likelion.crud.Service.CouponHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CouponHoldersController {
    @Autowired
    private CouponHoldersService couponHoldersService;

    @PostMapping("couponHolders")
    public CouponHolders allocCoupon(@RequestParam("member_id") Long member_id, @RequestParam("coupon_id")Long coupon_id){
        return couponHoldersService.allocCoupon(member_id,coupon_id);
    }

    @GetMapping("couponHolders")
    public List<CouponHolders> getAllCouponHolders(){
        return couponHoldersService.getAllCouponHolders();
    }

    @GetMapping("couponsFromMember")
    public List<Coupon> getAllCouponFromMember(@RequestParam("id") Long id){
        return couponHoldersService.getAllCouponFromMember(id);
    }

    @GetMapping("membersFromCoupon")
    public List<Member> getAllMemberFromCoupon(@RequestParam("id") Long id){
        return couponHoldersService.getAllMemberFromCoupon(id);
    }

    @DeleteMapping("couponHolders")
    public List<CouponHolders> removeCouponHolders(@RequestParam("member_id")Long member_id, @RequestParam("coupon_id") Long coupon_id){
        return couponHoldersService.removeCouponHolders(member_id,coupon_id);
    }


}
