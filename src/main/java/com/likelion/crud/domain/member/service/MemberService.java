package com.likelion.crud.domain.member.service;

import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.coupon.repository.CouponHolderRepository;
import com.likelion.crud.domain.member.MemberPatchDto;
import com.likelion.crud.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CouponHolderRepository couponHolderRepository;

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    public List<Member> findAllByCoupon() {
        return couponHolderRepository.findAllMember();
    }

    public List<Member> findAllByCoupon(Long couponId) {
        return couponHolderRepository.findAllMemberByCouponId(couponId);
    }

    public Member update(Long memberId, MemberPatchDto memberPatch) {
        return memberRepository.update(memberId, memberPatch);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
