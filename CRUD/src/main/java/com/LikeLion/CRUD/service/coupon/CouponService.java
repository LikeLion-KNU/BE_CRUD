package com.LikeLion.CRUD.service.coupon;

import com.LikeLion.CRUD.entity.coupon.Coupon;
import com.LikeLion.CRUD.exception.coupon.CouponNotFoundException;
import com.LikeLion.CRUD.repository.coupon.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    // 쿠폰 정보 수정
    public Coupon updateCoupon(Long id, Coupon couponDetails) {
        Optional<Coupon> couponOptional = couponRepository.findById(id);
        if (couponOptional.isPresent()) {
            Coupon couponToUpdate = couponOptional.get();

            couponToUpdate.setType(couponDetails.getType());
            couponToUpdate.setIssueDate(couponDetails.getIssueDate());
            couponToUpdate.setDiscount(couponDetails.getDiscount());
            couponToUpdate.setExpirationDate(couponDetails.getExpirationDate());

            return couponRepository.save(couponToUpdate);
        } else {
            throw new CouponNotFoundException("Coupon with ID " + id + " not found");
        }
    }

    public void deleteCoupon(Long id) {
        if(couponRepository.existsById(id)) {
            couponRepository.deleteById(id);
        } else {
            throw new CouponNotFoundException("Coupon with ID " + id + " not found");
        }
    }
}
