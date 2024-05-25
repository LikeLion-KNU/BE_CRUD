package controller;

import domain.CouponHolders;
import domain.Member;
import Service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/holders")
public class HolderController {

    private final CouponService couponService;

    /*
    모든 쿠폰 보유자 조회
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CouponHolders> findAllCouponHolders(){
        return couponService.findAllCouponHolders();
    }

    /*
    쿠폰 ID로 해당 쿠폰을 보유하고 있는 회원 조회
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{couponId}")
    public List<Member> findHoldersFromCoupon(@PathVariable Long couponId){
        return couponService.findHoldersByCouponId(couponId);
    }

}
