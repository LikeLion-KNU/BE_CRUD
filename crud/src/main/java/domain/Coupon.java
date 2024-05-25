package domain;

import dto.coupon.CouponUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coupon_id")
    private Long id;
    private Type type;
    private int discount;
    private LocalDateTime issueDate;
    private LocalDateTime expirationDate;

    @OneToMany(mappedBy = "coupon")
    private List<CouponHolders> couponHolders;

    public void update(CouponUpdateRequestDTO couponUpdateRequestDTO){
        this.type = couponUpdateRequestDTO.getType();
        this.discount = couponUpdateRequestDTO.getDiscount();
        this.expirationDate= couponUpdateRequestDTO.getExpirationDate();
    }
}
