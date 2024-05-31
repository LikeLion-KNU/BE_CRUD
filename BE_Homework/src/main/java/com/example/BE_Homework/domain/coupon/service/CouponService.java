package com.example.BE_Homework.domain.coupon.service;

import com.example.BE_Homework.domain.coupon.dto.CouponReadRequestDto;
import com.example.BE_Homework.domain.coupon.dto.CouponUpdateRequestDto;
import com.example.BE_Homework.domain.coupon.entity.Coupon;
import com.example.BE_Homework.domain.couponholders.entity.CouponHolders;
import com.example.BE_Homework.domain.member.entity.Member;
import com.example.BE_Homework.domain.couponholders.repository.CouponHoldersRepository;
import com.example.BE_Homework.domain.coupon.repository.CouponRepository;
import com.example.BE_Homework.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;
    private final CouponHoldersRepository couponHoldersRepository;

    public Coupon createCoupon(CouponReadRequestDto couponReadRequestDto){
        return couponRepository.save(Coupon.toEntity(couponReadRequestDto));
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    public Coupon updateCoupon(CouponUpdateRequestDto couponUpdateRequestDto){
        Coupon coupon = couponRepository.findById(couponUpdateRequestDto.id()).orElseThrow(() -> new IllegalArgumentException("Invalid Coupon Id"));
        coupon.update(couponUpdateRequestDto);
        return couponRepository.save(coupon);
    }
    public void deleteCoupon(Long id){
        couponRepository.deleteCouponById(id);
    }

    // 여기부턴 Holder 인가

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
        List<CouponHolders> couponHolderList = couponHoldersRepository.findCouponHoldersByCouponId(couponId);
        List<Member> memberList = new ArrayList<>();
        for (CouponHolders couponHolder : couponHolderList){
            memberList.add(couponHolder.getMember());
        }
        return memberList;
    }

    public List<Coupon> findCouponsByMemberId(Long memberId){
        List<CouponHolders> couponHolderList = couponHoldersRepository.findCouponHoldersByMemberId(memberId);
        List<Coupon> couponList = new ArrayList<>();
        for (CouponHolders couponHolder : couponHolderList){
            couponList.add(couponHolder.getCoupon());
        }
        return couponList;
    }

    public void deleteCouponFromMember(Long couponId, Long memberId){
        couponHoldersRepository.deleteByMemberIdAndCouponId(couponId, memberId);
    }

}
