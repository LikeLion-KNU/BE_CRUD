package dto.coupon;

import domain.Type;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CouponRegisterRequestDTO {
    @NonNull
    private Type type;
    private int discount;
    @NonNull
    private LocalDateTime expirationDate;
}
