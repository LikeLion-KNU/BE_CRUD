package likelion.demo.domain.holder.dto.response;

import likelion.demo.domain.coupon.dto.response.CouponReadResponse;
import likelion.demo.domain.coupon.entity.Coupon;
import likelion.demo.domain.coupon.entity.Type;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record FindCouponByMemberId(
        Type type,
        int discount,
        LocalDateTime issueDate,
        LocalDateTime expirationDate
) {
    public static List<FindCouponByMemberId> makeListFindCouponByMemberId(List<Coupon> coupons){
        return coupons.stream()
                .map(coupon -> FindCouponByMemberId.builder()
                        .discount(coupon.getDiscount())
                        .issueDate(coupon.getIssueDate())
                        .expirationDate(coupon.getExpirationDate())
                        .type(coupon.getType())
                        .build())
                .toList();
    }
}
