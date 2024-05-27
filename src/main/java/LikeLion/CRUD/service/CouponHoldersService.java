package LikeLion.CRUD.service;

import LikeLion.CRUD.entity.CouponHolders;
import LikeLion.CRUD.repository.CouponHoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponHoldersService {
    @Autowired
    private CouponHoldersRepository couponHoldersRepository;

    public List<CouponHolders> getAllCouponHolders() {
        return couponHoldersRepository.findAll();
    }

    public Optional<CouponHolders> getCouponHoldersById(Long id) {
        return couponHoldersRepository.findById(id);
    }

    public CouponHolders createCouponHolders(CouponHolders couponHolders) {
        return couponHoldersRepository.save(couponHolders);
    }

    public CouponHolders updateCouponHolders(Long id, CouponHolders couponHoldersDetails) {
        CouponHolders couponHolders = couponHoldersRepository.findById(id).orElseThrow();
        couponHolders.setCoupon(couponHoldersDetails.getCoupon());
        couponHolders.setMember(couponHoldersDetails.getMember());
        return couponHoldersRepository.save(couponHolders);
    }

    public void deleteCouponHolders(Long id) {
        couponHoldersRepository.deleteById(id);
    }
}