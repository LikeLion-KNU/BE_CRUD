package likelion.festival.assignment.domain.couponholder.service;


import likelion.festival.assignment.domain.coupon.entity.Coupon;
import likelion.festival.assignment.domain.coupon.repository.CouponRepository;
import likelion.festival.assignment.domain.couponholder.dto.request.CouponToMemberRequest;
import likelion.festival.assignment.domain.couponholder.dto.response.FindAllMemberWithCouponResponse;
import likelion.festival.assignment.domain.couponholder.dto.response.FindCouponWithMemberResponse;
import likelion.festival.assignment.domain.couponholder.dto.response.FindMemberWithCouponResponse;
import likelion.festival.assignment.domain.couponholder.entity.CouponHolder;
import likelion.festival.assignment.domain.couponholder.repository.CouponHolderRepository;
import likelion.festival.assignment.domain.member.dto.request.MemberSaveRequest;
import likelion.festival.assignment.domain.member.dto.response.MemberAllReadResponse;
import likelion.festival.assignment.domain.member.entity.Member;
import likelion.festival.assignment.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponHolderService {
    CouponHolder couponHolder;
    CouponHolderRepository couponHolderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    public CouponHolderService(CouponHolderRepository couponHolderRepository) {
        this.couponHolderRepository = couponHolderRepository;
    }

    /*특정 회원에게 쿠폰 할당*/
    @Transactional
    public Long couponToMember(CouponToMemberRequest couponToMemberRequest){
        Member member = memberRepository.findById(couponToMemberRequest.memberId()).get();
        Coupon coupon = couponRepository.findById(couponToMemberRequest.couponId()).get();

        CouponHolder couponholder = CouponHolder.builder()
                .member(member)
                .coupon(coupon)
                .build();

        couponHolderRepository.save(couponholder);


        return couponholder.getMember_coupon_id();
    }

/* 모든 쿠폰 보유자 조회*/
    public List<FindAllMemberWithCouponResponse> getAllCouponHolder(){
        try {
            List<CouponHolder> CouponHolderList = couponHolderRepository.findAll();
            List<FindAllMemberWithCouponResponse> responseList = new ArrayList<>();

            for (CouponHolder couponHolder : CouponHolderList) {
                responseList.add(
                        new FindAllMemberWithCouponResponse(couponHolder.getMember_coupon_id(), couponHolder.getMember().getId(), couponHolder.getCoupon().getId())
                );
                // 여기 dto 에 그대로 Member member, Coupon coupon을 넣어도 상관없느닞....?
            }
            return responseList;
        }catch(Exception e){

        }
        return null;
    }

    /*회원ID로 해당 회원이 보유하고 있는 쿠폰 조회*/
    public List<FindCouponWithMemberResponse> getCouponWithMember(Long memberId){
        //여기서 그냥 coupon 정보 조회 하는 dto 사용해도 되는지?
        //새로운 dto를 작성하는게 좋을지
        try{
            List<CouponHolder> CouponHolderList = couponHolderRepository.findByMemberId(memberId);
            List<FindCouponWithMemberResponse> responseList = new ArrayList<>();

            for(CouponHolder couponHolder: CouponHolderList){
                Coupon coupon = couponHolder.getCoupon();
                responseList.add(
                        new FindCouponWithMemberResponse(coupon.getId(), coupon.getType(), coupon.getDiscount(), coupon.getIssue_time(), coupon.getExpiration_time())
                );
            }
            return responseList;
        }catch(Exception e){
        }
        return null;
    }

    /*쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회*/
    public List<FindMemberWithCouponResponse> getMemberWithCoupon(Long couponId){
        try{
            List<CouponHolder> CouponHolderList = couponHolderRepository.findByCouponId(couponId);
            List<FindMemberWithCouponResponse> responseList = new ArrayList<>();

            for(CouponHolder couponHolder: CouponHolderList){
                Member member = couponHolder.getMember();
                responseList.add(
                        new FindMemberWithCouponResponse(member.getId(),member.getEmail(), member.getName(), member.getRole(), member.getAge() )
                );
            }
            return responseList;
        }catch(Exception e){
        }
        return null;
    }



    /*특정 회원의 쿠폰 삭제*/
    @Transactional
    public void deleteCouponWithMember(Long memberId, Long couponId) throws IOException{

        couponHolderRepository.deleteByMemberIdAndCouponId(memberId, couponId);
    }

}
