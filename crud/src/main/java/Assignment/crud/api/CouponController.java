package Assignment.crud.api;

import Assignment.crud.domain.Coupon;
import Assignment.crud.dto.CouponEditRequestDto;
import Assignment.crud.dto.CouponRequestDto;
import Assignment.crud.dto.CouponResponseDto;
import Assignment.crud.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    /**
     * 쿠폰 생성
     */
    @PostMapping("/api/coupons")
    public ResponseEntity<?> addCoupon(@RequestBody @Validated CouponRequestDto coupon,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return returnErrors(bindingResult);
        }

        Coupon newCoupon = Coupon.builder()
                .type(coupon.getType())
                .discount(coupon.getDiscount())
                .issueDate(LocalDateTime.now())
                .expirationDate(coupon.getExpirationDate())
                .build();

        Long newCouponId = couponService.join(newCoupon);

        return ResponseEntity.ok()
                .body(newCouponId);
    }

    /**
     * 쿠폰 조회
     */
    @GetMapping("/api/coupons")
    public ResponseEntity<?> findCoupons() {
        List<CouponResponseDto> coupons = couponService.findCoupons()
                .stream()
                .map(CouponResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(coupons);
    }

    /**
     * 쿠폰 정보 수정
     */
    @PutMapping("/api/coupons/{id}")
    public ResponseEntity<?> editCoupon(@PathVariable("id") Long id,
                                        @RequestBody @Validated CouponEditRequestDto coupon,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return returnErrors(bindingResult);
        }

        couponService.editCoupon(id, coupon);

        return ResponseEntity.ok()
                .body(id);
    }

    /**
     * 쿠폰 삭제
     */
    @DeleteMapping("/api/coupons/{id}")
    public ResponseEntity<?> deleteCoupon(@PathVariable("id") Long id) {
        couponService.deleteCoupon(id);

        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Map<String, String>> returnErrors(BindingResult bindingResult) {
        return ResponseEntity.badRequest()
                .body(bindingResult.getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
    }
}
