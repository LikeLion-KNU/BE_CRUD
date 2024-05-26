package com.likelion.crud.Repository;

import com.likelion.crud.Entity.Coupon;
import com.likelion.crud.Entity.CouponHolders;
import com.likelion.crud.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CouponHoldersRepository extends JpaRepository<CouponHolders,Long> {
    @Transactional
    void deleteByMember_MemberIdAndCoupon_CouponId(Long member_id, Long coupon_id);

}
