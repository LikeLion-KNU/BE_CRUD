package com.example.BE_Homework.service;

import com.example.BE_Homework.dto.CouponReq;
import com.example.BE_Homework.entity.Coupon;
import com.example.BE_Homework.entity.CouponHolders;
import com.example.BE_Homework.entity.Member;
import com.example.BE_Homework.repository.CouponHoldersRepository;
import com.example.BE_Homework.repository.CouponRepository;
import com.example.BE_Homework.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.management.LockInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Coupon updateCoupon(Coupon coupon){
        Coupon existCoupon = couponRepository.findById(coupon.getCouponId()).orElseThrow(() -> new IllegalArgumentException("Invalid Coupon Id"));

        existCoupon.setType(coupon.getType());
        existCoupon.setDiscount(coupon.getDiscount());
        existCoupon.setExpirationDate(coupon.getExpirationDate());
        existCoupon.setIssueDate(LocalDateTime.now());

        return couponRepository.save(existCoupon);
    }

    public List<CouponHolders> getAllCouponHolders(){
        return couponHoldersRepository.findAll();
    }

    public void assignCouponToMember(Long couponId, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Invalid Member Id"));
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() -> new IllegalArgumentException("Invalid Coupon Id"));

        CouponHolders couponHolders = new CouponHolders();
        couponHolders.setCoupon(coupon);
        couponHolders.setMember(member);

        couponHoldersRepository.save(couponHolders);
    }

    public List<Member> findMembersByCouponId(Long couponId){
        List<CouponHolders> couponHolderList = couponHoldersRepository.findHoldersByCouponId(couponId);
        List<Member> memberList = new ArrayList<>();
        for (CouponHolders couponHolder : couponHolderList){
            memberList.add(couponHolder.getMember());
        }
        return memberList;
    }

    public List<Coupon> findCouponsByMemberId(Long memberId){
        List<CouponHolders> couponHolderList = couponHoldersRepository.findHoldersByMemberId(memberId);
        List<Coupon> couponList = new ArrayList<>();
        for (CouponHolders couponHolder : couponHolderList){
            couponList.add(couponHolder.getCoupon());
        }
        return couponList;
    }

    public void deleteCouponFromMember(Long couponId, Long memberId){
        couponHoldersRepository.deleteMemberIdAndCouponId(couponId, memberId);
    }

}
