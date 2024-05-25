package com.likelion.crud.service;

import com.likelion.crud.dto.CouponCreateReq;
import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.CouponHolder;
import com.likelion.crud.entity.Member;
import com.likelion.crud.repository.CouponHolderRepository;
import com.likelion.crud.repository.CouponRepository;
import com.likelion.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponService {

    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;
    private final CouponHolderRepository couponHolderRepository;

    @Autowired
    public CouponService(MemberRepository memberRepository, CouponRepository couponRepository, CouponHolderRepository couponHolderRepository) {
        this.memberRepository = memberRepository;
        this.couponRepository = couponRepository;
        this.couponHolderRepository = couponHolderRepository;
    }

    public Coupon createCoupon(CouponCreateReq couponCreateReq) {

        Coupon coupon = Coupon.builder()
                .type(couponCreateReq.type())
                .discount(couponCreateReq.discount())
                .issueDate(LocalDateTime.now())
                .expirationDate(couponCreateReq.expirationDate())
                .build();

        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon updateCoupon(Coupon coupon) {

        Coupon findCoupon = couponRepository.findById(coupon.getCouponId())
                .orElseThrow(() -> new IllegalArgumentException("Coupon Not Found"));

        findCoupon.setType(coupon.getType());
        findCoupon.setDiscount(coupon.getDiscount());
        findCoupon.setIssueDate(coupon.getIssueDate());
        findCoupon.setExpirationDate(coupon.getExpirationDate());

        return couponRepository.save(findCoupon);
    }

    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }

    public void assignCouponToMember(Long memberId, Long couponId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid coupon ID"));

        CouponHolder couponHolder = new CouponHolder();
        couponHolder.setMember(member);
        couponHolder.setCoupon(coupon);

        couponHolderRepository.save(couponHolder);
    }

    public List<CouponHolder> getAllCouponHolders() {
        return couponHolderRepository.findAll();
    }

    public List<Coupon> getCouponsByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        List<CouponHolder> couponHolders = couponHolderRepository.findByMember(member);
        return couponHolders.stream().map(CouponHolder::getCoupon).toList();
    }

    public List<Member> getMembersByCoupon(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid coupon ID"));

        List<CouponHolder> couponHolders = couponHolderRepository.findByCoupon(coupon);
        return couponHolders.stream().map(CouponHolder::getMember).toList();
    }

    public void removeCouponFromMember(Long memberId, Long couponId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid coupon ID"));

        CouponHolder couponHolder = couponHolderRepository.findByMemberAndCoupon(member, coupon)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not assigned to member"));

        couponHolderRepository.delete(couponHolder);
    }

}
