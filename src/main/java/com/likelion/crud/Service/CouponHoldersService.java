package com.likelion.crud.Service;

import com.likelion.crud.Entity.Coupon;
import com.likelion.crud.Entity.CouponHolders;
import com.likelion.crud.Entity.Member;
import com.likelion.crud.Repository.CouponHoldersRepository;
import com.likelion.crud.Repository.CouponRepository;
import com.likelion.crud.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CouponHoldersService {
    private final CouponHoldersRepository couponHoldersRepository;
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public CouponHoldersService(CouponHoldersRepository couponHoldersRepository, MemberRepository memberRepository, CouponRepository couponRepository){
        this.couponHoldersRepository = couponHoldersRepository;
        this.memberRepository = memberRepository;
        this.couponRepository = couponRepository;
    }

    @Transactional
    public CouponHolders allocCoupon(Long member_id, Long coupon_id){
        try{
            Member member = memberRepository.findById(member_id).get();
            Coupon coupon = couponRepository.findById(coupon_id).get();
            CouponHolders newHolder = new CouponHolders();
            newHolder.setMember(member);
            newHolder.setCoupon(coupon);
            return couponHoldersRepository.save(newHolder);
        }catch(NoSuchElementException e) {
        }
        return null;
    }

    public List<CouponHolders> getAllCouponHolders(){return couponHoldersRepository.findAll();}

    public List<Coupon> getAllCouponFromMember(Long member_id){
        try{
            Member target = memberRepository.findById(member_id).get();
            List<CouponHolders> couponHolders = target.getCouponHolders();
            List<Coupon> res = new ArrayList<>();
            couponHolders.forEach(_couponHolders -> res.add(_couponHolders.getCoupon()));
            return res;
        }catch(NoSuchElementException e){
        }
        return null;
    }

    public List<Member> getAllMemberFromCoupon(Long coupon_id){
        try{
            Coupon target = couponRepository.findById(coupon_id).get();
            List<CouponHolders> couponHolders = target.getCouponHolders();
            List<Member> res = new ArrayList<>();
            couponHolders.forEach(_couponHolders -> res.add(_couponHolders.getMember()));
            return res;
        }catch(NoSuchElementException e){
        }
        return null;
    }

    @Transactional
    public List<CouponHolders> removeCouponHolders(Long member_id, Long coupon_id){
        couponHoldersRepository.deleteByMember_MemberIdAndCoupon_CouponId(member_id, coupon_id);
        return couponHoldersRepository.findAll();
    }


}
