package likelion.demo.domain.holder.service;

import jakarta.persistence.EntityNotFoundException;
import likelion.demo.domain.coupon.dto.response.MemberWithAllCouponsResponse;
import likelion.demo.domain.coupon.entity.Coupon;
import likelion.demo.domain.coupon.repository.CouponRepository;
import likelion.demo.domain.coupon.service.CouponService;
import likelion.demo.domain.holder.dto.request.AssignCouponRequest;
import likelion.demo.domain.holder.dto.response.FindCouponByMemberId;
import likelion.demo.domain.holder.dto.response.FindMemberByCouponId;
import likelion.demo.domain.holder.entity.CouponHolder;
import likelion.demo.domain.holder.repository.CouponHolderRepository;
import likelion.demo.domain.member.entity.Member;
import likelion.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponHolderService {

    private final CouponHolderRepository couponHolderRepository;
    private final CouponRepository couponRepository;
    private final MemberService memberService;
    private final CouponService couponService;


    /**
     * 특정 회원에게 쿠폰 할당
     * @param assignCouponRequest
     * @return
     */
    @Transactional
    public Long AssignCouponToMember(AssignCouponRequest assignCouponRequest){
        Member member = memberService.findMemberById(assignCouponRequest.memberId());
        Coupon coupon=couponService.findCouponById(assignCouponRequest.couponId());

        CouponHolder couponHolder =CouponHolder.builder()
                .member(member)
                .coupon(coupon)
                .build();

        couponHolderRepository.save(couponHolder);

        return couponHolder.getId();
    }

    /**
     * 모든 쿠폰을 가진 멤버 목록 조회
     * @return 모든 쿠폰을 가진 멤버 목록
     */
    public List<MemberWithAllCouponsResponse> getMembersWithAllCoupons() {
        // 모든 쿠폰 조회
        List<Coupon> allCoupons = couponRepository.findAll();

        // 모든 멤버 조회
        List<Member> allMembers = couponHolderRepository.findAll().stream()
                .map(CouponHolder::getMember)
                .distinct()
                .collect(Collectors.toList());

        // 모든 쿠폰을 가진 멤버 필터링 후 변환
        return allMembers.stream()
                .filter(member -> hasAllCoupons(member, allCoupons))
                .map(member -> new MemberWithAllCouponsResponse(member.getEmail()))
                .collect(Collectors.toList());
    }

    private boolean hasAllCoupons(Member member, List<Coupon> allCoupons) {
        List<Coupon> memberCoupons = couponHolderRepository.findByMember_Id(member.getId()).stream()
                .map(CouponHolder::getCoupon)
                .collect(Collectors.toList());

        return allCoupons.stream().allMatch(memberCoupons::contains);
    }

    /**
     *  특정 회원이 가지고 있는 모든 쿠폰 정보 조회
     * @param memberId
     * @return
     */
    public List<FindCouponByMemberId> couponAllMemberService(Long memberId){
        List<CouponHolder> couponHolders = couponHolderRepository.findByMember_Id(memberId);
        List<Coupon> coupons =  couponHolders.stream()
                .map(CouponHolder::getCoupon) // CouponHolder에서 Coupon을 추출
                .collect(Collectors.toList()); // List<Coupon>으로 변환
        List<FindCouponByMemberId> findCouponByMemberIds = FindCouponByMemberId.makeListFindCouponByMemberId(coupons);

        return findCouponByMemberIds;
    }

    /**
     * 특정 쿠폰을 소지하고 있는 회원 정보 조희
     * @param couponId
     * @return
     */

    public List<FindMemberByCouponId> memberAllCouponService(Long couponId){
        List<CouponHolder> couponHolders = couponHolderRepository.findByCoupon_Id(couponId);
        List<Member> members =  couponHolders.stream()
                .map(CouponHolder::getMember) // CouponHolder에서 Coupon을 추출
                .collect(Collectors.toList()); // List<Coupon>으로 변환

        List<FindMemberByCouponId> findMemberRespons = members.stream()
                .map(member -> new FindMemberByCouponId(member.getEmail())) // Member 객체를 CouponMemberResponse로 변환
                .collect(Collectors.toList());

        return findMemberRespons;
    }

    /**
     * 특정 회원의 쿠폰 삭제
     * @param memberId
     */
    public void deleteMemberCoupon(Long memberId,Long couponId){
        Member member = memberService.findMemberById(memberId);
        Coupon coupon =couponService.findCouponById(couponId);
        CouponHolder couponHolder = couponHolderRepository.findByMemberAndCoupon(member,coupon)
                    .orElseThrow(() -> new EntityNotFoundException("해당 쿠폰을 가진 멤버는 없습니다."));

        couponHolderRepository.delete(couponHolder);
    }



}
