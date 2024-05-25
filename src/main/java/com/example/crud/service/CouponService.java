package com.example.crud.service;

import com.example.crud.dto.coupon.CreateCouponDto.CreateCouponRequest;
import com.example.crud.dto.coupon.CreateCouponDto.CreateCouponResponse;
import com.example.crud.dto.coupon.SimpleCouponDto;
import com.example.crud.dto.coupon.UpdateCouponDto.UpdateCouponRequest;
import com.example.crud.dto.coupon.UpdateCouponDto.UpdateCouponResponse;
import com.example.crud.dto.member.SimpleMemberDto;
import com.example.crud.entity.Coupon;
import com.example.crud.entity.CouponHolder;
import com.example.crud.entity.Member;
import com.example.crud.repository.CouponHolderRepository;
import com.example.crud.repository.CouponRepository;
import com.example.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponHolderRepository couponHolderRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public CreateCouponResponse createCoupon(CreateCouponRequest request){
        Coupon coupon = Coupon.builder()
                .couponType(request.getCouponType())
                .discount(request.getDiscount())
                .issueDate(LocalDateTime.now())
                .expirationDate(
                        LocalDateTime.now().plusMonths(request.getExpiration()))
                .build();
        couponRepository.save(coupon);
        return CreateCouponResponse.toDto(coupon);
    }

    @Transactional
    public UpdateCouponResponse updateCoupon(UpdateCouponRequest request){
        Coupon coupon = findCouponById(request.getCouponId());
        coupon.update(request.getCouponType(),request.getDiscount());
        return UpdateCouponResponse.toDto(coupon);
    }

    @Transactional
    public void deleteCoupon(Long couponId){
        couponRepository.deleteById(couponId);
    }

    @Transactional
    public void deleteCouponHolderByMember(Long memberId){
        couponHolderRepository.findCouponsByMemberId(memberId)
                .ifPresent(couponHolderRepository::deleteAll
                );
    }

    @Transactional
    public void allocateCoupon(Long memberId, Long couponId){
        Coupon coupon = findCouponById(couponId);
        Member member = findMemberById(memberId);
        CouponHolder couponHolder = CouponHolder.builder()
                .coupon(coupon)
                .member(member)
                .build();
        couponHolderRepository.save(couponHolder);
    }

    public List<SimpleCouponDto> findAllCoupons(){
        return couponRepository.findAll()
                .stream()
                .map(SimpleCouponDto::toDto)
                .collect(Collectors.toList());
    }

    public List<SimpleCouponDto> findAllCouponHolders(){
        return couponHolderRepository.findAll()
                .stream()
                .map(SimpleCouponDto::toDtoWithMember)
                .collect(Collectors.toList());
    }

    public List<SimpleCouponDto> findCouponsByMember(Long memberId){
        return couponHolderRepository.findCouponsByMemberId(memberId)
                .orElse(Collections.emptyList())
                .stream()
                .map(couponHolder -> SimpleCouponDto.toDto(couponHolder.getCoupon()))
                .collect(Collectors.toList());
    }

    public List<SimpleMemberDto> findMembersByCoupon(Long couponId){
        return couponHolderRepository.findCouponHolderByCouponId(couponId)
                .orElse(Collections.emptyList())
                .stream()
                .map(couponHolder -> SimpleMemberDto.toDto(couponHolder.getMember()))
                .collect(Collectors.toList());
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()-> new RuntimeException("No Such Member"));
    }

    private Coupon findCouponById(Long couponId) {
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("No Such Coupon"));
    }

}
