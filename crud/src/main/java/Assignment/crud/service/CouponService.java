package Assignment.crud.service;

import Assignment.crud.domain.Coupon;
import Assignment.crud.domain.CouponHolders;
import Assignment.crud.domain.Member;
import Assignment.crud.dto.CouponEditRequestDto;
import Assignment.crud.repository.CouponHoldersRepository;
import Assignment.crud.repository.CouponRepository;
import Assignment.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {

    private final CouponRepository couponRepository;
    private final MemberRepository memberRepository;
    private final CouponHoldersRepository couponHoldersRepository;

    @Transactional
    public Long join(Coupon coupon) {

        Coupon savedCoupon = couponRepository.save(coupon);

        return savedCoupon.getId();
    }

    public List<Coupon> findCoupons() {
        return couponRepository.findAll();
    }

    @Transactional
    public void editCoupon(Long id, CouponEditRequestDto coupon) {

        Coupon findCoupon = couponRepository.findById(id).get();

        findCoupon.setType(coupon.getType());
        findCoupon.setDiscount(coupon.getDiscount());
        findCoupon.setExpirationDate(coupon.getExpirationDate());
    }

    @Transactional
    public void deleteCoupon(Long id) {

        couponRepository.deleteById(id);
    }

    @Transactional
    public CouponHolders assignCouponToMember(Long memberId, Long couponId) {

        Member member = memberRepository.findById(memberId).get();
        Coupon coupon = couponRepository.findById(couponId).get();

        CouponHolders holder = CouponHolders.builder()
                .member(member)
                .coupon(coupon)
                .build();

        return couponHoldersRepository.save(holder);
    }

    public List<CouponHolders> getAllCouponHolders() {

        return couponHoldersRepository.findAll();
    }

    public List<CouponHolders> getCouponsByMemberId(Long memberId) {

        return couponHoldersRepository.findByMemberId(memberId);
    }

    public List<CouponHolders> getMembersByCouponId(Long couponId) {

        return couponHoldersRepository.findByCouponId(couponId);
    }

    @Transactional
    public void deleteCouponFromMember(Long memberId, Long couponId) {

        couponHoldersRepository.deleteByMemberIdAndCouponId(memberId, couponId);
    }

}
