package LikeLion.CRUD.service;

import LikeLion.CRUD.entity.Coupon;
import LikeLion.CRUD.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Optional<Coupon> getCouponById(Long id) {
        return couponRepository.findById(id);
    }

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Coupon updateCoupon(Long id, Coupon couponDetails) {
        Coupon coupon = couponRepository.findById(id).orElseThrow();
        coupon.setType(couponDetails.getType());
        coupon.setDiscount(couponDetails.getDiscount());
        coupon.setIssueDate(couponDetails.getIssueDate());
        coupon.setExpirationDate(couponDetails.getExpirationDate());
        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }
}