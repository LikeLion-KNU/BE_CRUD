package com.LikeLion.CRUD.service.relationship;

import com.LikeLion.CRUD.dto.member.MemberInfoDTO;
import com.LikeLion.CRUD.entity.coupon.Coupon;
import com.LikeLion.CRUD.entity.member.Member;
import com.LikeLion.CRUD.entity.relation.CouponHolders;
import com.LikeLion.CRUD.exception.coupon.CouponNotFoundException;
import com.LikeLion.CRUD.exception.member.MemberNotFoundException;
import com.LikeLion.CRUD.repository.coupon.CouponRepository;
import com.LikeLion.CRUD.repository.member.MemberRepository;
import com.LikeLion.CRUD.repository.relation.CouponHoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponHoldersService {

    @Autowired
    private CouponHoldersRepository couponHoldersRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private MemberRepository memberRepository;

    // 특정 회원에게 쿠폰 할당
    public CouponHolders assignCouponToMember(Long memberId, Long couponId) {
        CouponHolders couponHolders = new CouponHolders();

        // Coupon과 Member 엔티티를 조회
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found with id: " + couponId));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found with id: " + memberId));

        // 조회된 Coupon과 Member를 CouponHolders에 설정 고고
        couponHolders.setCoupon(coupon);
        couponHolders.setMember(member);

        // 설정된 CouponHolders 엔티티를 저장하기
        return couponHoldersRepository.save(couponHolders);
    }

    // 모든 쿠폰 보유자 조회 -> DTO 적용
    public List<MemberInfoDTO> findAllCouponHolders() {

        // 모든 CouponHolders 인스턴스를 가져옵니다.
        List<CouponHolders> couponHoldersList = couponHoldersRepository.findAll();

        // CouponHolders 리스트를 MemberInfoDTO 리스트로 변환합니다.
        return couponHoldersList.stream()
                .map(couponHolder -> {
                    Member member = couponHolder.getMember(); // CouponHolders로부터 Member 인스턴스를 가져옵니다.
                    MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
                    memberInfoDTO.setEmail(member.getEmail());
                    memberInfoDTO.setRole(member.getRole());
                    memberInfoDTO.setName(member.getName());
                    memberInfoDTO.setAge(member.getAge());
                    memberInfoDTO.setIsAccountExpired(member.getIsAccountExpired());
                    memberInfoDTO.setIsAccountLocked(member.getIsAccountLocked());
                    return memberInfoDTO;
                }).collect(Collectors.toList());
    }

    // 회원ID로 해당 회원이 보유하고 있는 쿠폰 조회
    public List<Coupon> findCouponsByMemberId(Long memberId) {
        List<CouponHolders> couponHoldersList = couponHoldersRepository.findAllByMemberId(memberId);
        return couponHoldersList.stream().map(couponHolder -> {
            Coupon coupons = new Coupon();
            coupons.setId(couponHolder.getCoupon().getId());
            coupons.setType(couponHolder.getCoupon().getType());
            coupons.setDiscount(couponHolder.getCoupon().getDiscount());
            coupons.setIssueDate(couponHolder.getCoupon().getIssueDate());
            coupons.setExpirationDate(couponHolder.getCoupon().getExpirationDate());
            return coupons;
        }).collect(Collectors.toList());
    }

    // 쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회 -> DTO 적용
    public List<MemberInfoDTO> findMembersByCouponId(Long couponId) {
        List<CouponHolders> couponHoldersList = couponHoldersRepository.findAllByCouponId(couponId);

        return couponHoldersList.stream().map(couponHolder -> {
            MemberInfoDTO dto = new MemberInfoDTO();
            dto.setEmail(couponHolder.getMember().getEmail());
            dto.setRole(couponHolder.getMember().getRole());
            dto.setName(couponHolder.getMember().getName());
            dto.setAge(couponHolder.getMember().getAge());
            dto.setIsAccountExpired(couponHolder.getMember().getIsAccountExpired());
            dto.setIsAccountLocked(couponHolder.getMember().getIsAccountLocked());
            return dto;
        }).collect(Collectors.toList());
    }

    // 특정 회원의 쿠폰 삭제
    public void deleteMemberCoupon(Long memberId, Long couponId) {
        couponHoldersRepository.deleteByMemberIdAndCouponId(memberId, couponId);
    }
}
