package dto.coupon;

import domain.Coupon;
import domain.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CouponUpdateResponseDTO {
    private Long id;
    private Type type;
    private int discount;
    private LocalDateTime issueDate;
    private LocalDateTime expirationDate;

    public void update(Coupon coupon){
        id = coupon.getId();
        type = coupon.getType();
        discount = coupon.getDiscount();
        issueDate = coupon.getIssueDate();
        expirationDate = coupon.getExpirationDate();
    }
}
