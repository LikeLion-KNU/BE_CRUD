package com.likelion.crud.Service;

import com.likelion.crud.Entity.Coupon;
import com.likelion.crud.Entity.CouponType;
import com.likelion.crud.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CouponService {
    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository){
        this.couponRepository = couponRepository;
    }

    @Transactional
    public Coupon addCoupon(Coupon coupon){return couponRepository.save(coupon);}

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    @Transactional
    public Optional<Coupon> editCoupon(Long id, CouponType type, int discount, LocalDateTime issue_date, LocalDateTime expiration_date){
        try{
            Coupon _coupon = couponRepository.findById(id).get();
            if(type != null) _coupon.setType(type);
            if(discount != 0) _coupon.setDiscount(discount);
            if(issue_date != null) _coupon.setIssue_date(issue_date);
            if(expiration_date != null) _coupon.setExpiration_date(expiration_date);
            couponRepository.save(_coupon);
        }catch(NoSuchElementException e){

        }
        return couponRepository.findById(id);
    }

    @Transactional
    public List<Coupon> removeCoupon(Long id){
        couponRepository.deleteById(id);
        return couponRepository.findAll();
    }



}
