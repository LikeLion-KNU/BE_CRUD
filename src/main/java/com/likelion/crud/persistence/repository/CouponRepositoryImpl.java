package com.likelion.crud.persistence.repository;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.coupon.CouponPatchDto;
import com.likelion.crud.domain.coupon.repository.CouponRepository;
import com.likelion.crud.persistence.entity.CouponEntity;
import com.likelion.crud.persistence.repository.jpa.JpaCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepository {

    private final JpaCouponRepository repository;

    @Override
    public Coupon save(Coupon coupon) {
        return repository.save(CouponEntity.fromDomain(coupon)).toDomain();
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        return repository.findById(id).map(CouponEntity::toDomain);
    }

    @Override
    public List<Coupon> findAll() {
        return repository.findAll().stream().map(CouponEntity::toDomain).toList();
    }

    @Override
    public Coupon update(Long couponId, CouponPatchDto couponPatch) {
        CouponEntity couponEntity = repository.findById(couponId).orElseThrow();
        return repository.save(applyUpdate(couponEntity, couponPatch)).toDomain();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private static CouponEntity applyUpdate(CouponEntity couponEntity, CouponPatchDto couponPatch) {
        return new CouponEntity(
                couponEntity.getCouponId(),
                couponPatch.type() != null ? couponPatch.type() : couponEntity.getType(),
                couponPatch.discount() != null ? couponPatch.discount() : couponEntity.getDiscount(),
                couponEntity.getIssueDate(),
                couponEntity.getExpirationDate()
        );
    }
}
