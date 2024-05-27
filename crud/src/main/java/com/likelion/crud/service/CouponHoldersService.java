package com.likelion.crud.service;

import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.CouponHolders;
import com.likelion.crud.entity.Member;
import com.likelion.crud.repository.CouponHoldersRepository;
import com.likelion.crud.repository.CouponRepository;
import com.likelion.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponHoldersService {

    private CouponHoldersRepository couponHoldersRepository;
    private MemberRepository memberRepository;
    private CouponRepository couponRepository;


    //툭정 회원 할당
    @Transactional
    public void giveCouponToMember(Long memberId, Long couponId) {
       Member member = memberRepository.findById(memberId).orElseThrow();
       Coupon coupon = couponRepository.findById(couponId).orElseThrow();
       CouponHolders couponHolders = new CouponHolders();
       couponHolders.setCoupon(coupon);
       couponHolders.setMember(member);
       couponHoldersRepository.save(couponHolders);
    }

    //모든 쿠폰 조회
    public List<CouponHolders> findAllCouponHolders() {
        return couponHoldersRepository.findAll();
    }
    //회원 ID 쿠폰 조회
    public List<CouponHolders> findByMemberId(Long memberId){
        List<CouponHolders> couponHoldersList = couponHoldersRepository.findByMemberId(memberId);
        return couponHoldersList;
    }
    //쿠폰 ID 회원 조회
    public List<CouponHolders> findByCouponId(Long couponId) {
        List<CouponHolders> couponHoldersList = couponHoldersRepository.findByCouponId(couponId);
        return couponHoldersList;
    }
    //특정 회원 쿠폰 삭제
    public void deleteMemberCoupon(Long memberId, Long couponId) {
        couponHoldersRepository.deleteByMemberIdAndCouponId(memberId, couponId);
    }

}
