package Service;

import dto.coupon.CouponRegisterRequestDTO;
import domain.Coupon;
import domain.CouponHolders;
import dto.coupon.CouponRegisterResponseDTO;
import dto.coupon.CouponUpdateRequestDTO;
import domain.Member;
import dto.coupon.CouponUpdateResponseDTO;
import repository.CouponHolderRepository;
import repository.CouponRepository;
import repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;
    private final CouponHolderRepository couponHolderRepository;

    @Transactional
    public CouponRegisterResponseDTO registerCoupon(CouponRegisterRequestDTO couponRegisterRequestDTO){
        Coupon coupon = Coupon.builder()
                .discount(couponRegisterRequestDTO.getDiscount())
                .type(couponRegisterRequestDTO.getType())
                .expirationDate(couponRegisterRequestDTO.getExpirationDate())
                .issueDate(LocalDateTime.now())
                .build();
        couponRepository.save(coupon);
        CouponRegisterResponseDTO couponRegisterResponseDTO = new CouponRegisterResponseDTO();
        couponRegisterResponseDTO.update(coupon);
        return couponRegisterResponseDTO;
    }
    public List<Coupon> findAllCoupons(){
        return couponRepository.findAll();
    }
    @Transactional
    public CouponUpdateResponseDTO editCoupon(Long couponId, CouponUpdateRequestDTO couponUpdateRequestDTO){
        Coupon findCoupon = couponRepository.findById(couponId).orElseThrow();
        findCoupon.update(couponUpdateRequestDTO);
        CouponUpdateResponseDTO couponUpdateResponseDTO= new CouponUpdateResponseDTO();
        couponUpdateResponseDTO.update(findCoupon);
        return couponUpdateResponseDTO;
    }
    @Transactional
    public void deleteCoupon(Long couponId){
        couponRepository.deleteById(couponId);
    }
    @Transactional
    public Long assignCouponToMember(Long memberId, Long couponId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Coupon coupon = couponRepository.findById(couponId).orElseThrow();
        return couponHolderRepository.save(new CouponHolders(member,coupon)).getMemberCouponId();
    }
    public List<CouponHolders> findAllCouponHolders(){
        return couponHolderRepository.findAll();
    }
    public List<Coupon> findCouponsByMemberId(Long memberId){
        List<CouponHolders> couponHolders = couponHolderRepository.findByMemberId(memberId);
        List<Coupon> coupons = new ArrayList<>();
        for (CouponHolders couponHolder : couponHolders) {
            coupons.add(couponHolder.getCoupon());
        }
        return coupons;
    }
    public List<Member> findHoldersByCouponId(Long couponId){
        List<CouponHolders> couponHolders = couponHolderRepository.findByCouponId(couponId);
        List<Member> members = new ArrayList<>();
        for (CouponHolders couponHolder : couponHolders) {
            members.add(couponHolder.getMember());
        }
        return members;
    }
    @Transactional
    public void deleteCouponFromMember(Long memberId,Long couponId){
        couponHolderRepository.deleteByMemberIdAndCouponId(memberId,couponId);
    }

}