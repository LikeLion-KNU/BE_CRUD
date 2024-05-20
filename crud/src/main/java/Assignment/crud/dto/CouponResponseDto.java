package Assignment.crud.dto;

import Assignment.crud.domain.Coupon;
import Assignment.crud.domain.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CouponResponseDto {

    private Long id;

    private Type type;

    private int discount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime issueDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime expirationDate;


    public CouponResponseDto(Coupon coupon) {
        this.id = coupon.getId();
        this.type = coupon.getType();
        this.discount = coupon.getDiscount();
        this.issueDate = coupon.getIssueDate();
        this.expirationDate = coupon.getExpirationDate();
    }
}
