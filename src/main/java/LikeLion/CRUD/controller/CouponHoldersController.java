package LikeLion.CRUD.controller;

import LikeLion.CRUD.entity.CouponHolders;
import LikeLion.CRUD.service.CouponHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/couponHolders")
public class CouponHoldersController {
    @Autowired
    private CouponHoldersService couponHoldersService;

    @GetMapping
    public List<CouponHolders> getAllCouponHolders() {
        return couponHoldersService.getAllCouponHolders();
    }

    @GetMapping("/{id}")
    public Optional<CouponHolders> getCouponHoldersById(@PathVariable Long id) {
        return couponHoldersService.getCouponHoldersById(id);
    }

    @PostMapping
    public CouponHolders createCouponHolders(@RequestBody CouponHolders couponHolders) {
        return couponHoldersService.createCouponHolders(couponHolders);
    }

    @PutMapping("/{id}")
    public CouponHolders updateCouponHolders(@PathVariable Long id, @RequestBody CouponHolders couponHoldersDetails) {
        return couponHoldersService.updateCouponHolders(id, couponHoldersDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCouponHolders(@PathVariable Long id) {
        couponHoldersService.deleteCouponHolders(id);
    }
}