package Assignment.crud.dto;


import Assignment.crud.domain.CouponHolders;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CouponHoldersResponseDto {

    private MemberResponseDto member;
    private CouponResponseDto coupon;

    public CouponHoldersResponseDto(CouponHolders couponHolders) {
        this.member = new MemberResponseDto(couponHolders.getMember());
        this.coupon = new CouponResponseDto(couponHolders.getCoupon());
    }
}
