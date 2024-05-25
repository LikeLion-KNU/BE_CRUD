package dto.coupon;

import domain.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CouponRegisterRequestDTO {
    private Type type;
    private int discount;
    private LocalDateTime expirationDate;
}
