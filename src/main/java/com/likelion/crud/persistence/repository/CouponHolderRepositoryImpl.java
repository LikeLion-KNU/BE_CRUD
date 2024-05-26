package com.likelion.crud.persistence.repository;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.coupon.repository.CouponHolderRepository;
import com.likelion.crud.persistence.entity.CouponEntity;
import com.likelion.crud.persistence.entity.CouponHoldersEntity;
import com.likelion.crud.persistence.entity.MemberEntity;
import com.likelion.crud.persistence.repository.jpa.JpaCouponHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CouponHolderRepositoryImpl implements CouponHolderRepository {

    private final JpaCouponHolderRepository repository;

    @Override
    public List<Coupon> findAllCouponByMemberId(Long memberId) {
        return repository
                .findAllByMember_MemberId(memberId)
                .stream()
                .map(couponHoldersEntity ->
                        couponHoldersEntity.getCoupon().toDomain()
                )
                .toList();
    }

    @Override
    public List<Member> findAllMember() {
        return repository
                .findAll()
                .stream()
                .map(couponHoldersEntity ->
                        couponHoldersEntity.getMember().toDomain()
                )
                .toList();
    }

    @Override
    public List<Member> findAllMemberByCouponId(Long couponId) {
        return repository
                .findAllByCoupon_CouponId(couponId)
                .stream()
                .map(couponHoldersEntity ->
                        couponHoldersEntity.getMember().toDomain()
                )
                .toList();
    }

    @Override
    public void save(Member member, Coupon coupon) {
        CouponHoldersEntity couponHoldersEntity = new CouponHoldersEntity(
                null,
                MemberEntity.fromDomain(member),
                CouponEntity.fromDomain(coupon)
        );
        repository.save(couponHoldersEntity);
    }

    @Override
    public void deleteAllByMemberId(Long memberId) {
        repository.deleteAllByMember_MemberId(memberId);
    }
}
