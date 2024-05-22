package likelion.festival.assignment.domain.coupon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import likelion.festival.assignment.domain.coupon.dto.request.CouponUpdateRequest;
import likelion.festival.assignment.domain.couponholder.entity.CouponHolder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name="type")
    private Type type;

    @Column(name="discount")
    private int discount;

    @Column(name="issue_time")
    private LocalDateTime issue_time;

    @Column(name="expiration_time")
    private LocalDateTime expiration_time;

    @OneToMany(mappedBy = "coupon",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CouponHolder> couponHolderList;


    @Builder
    public Coupon(Type type, int discount, LocalDateTime issue_time, LocalDateTime expiration_time )
    {
        this.type = type;
        this.discount = discount;
        this.issue_time = issue_time;
        this.expiration_time = expiration_time;
    }

    public void updateCoupon(CouponUpdateRequest couponUpdateRequest)
    {
        this.type = couponUpdateRequest.type();
        this.discount = couponUpdateRequest.discount();
        this.expiration_time = couponUpdateRequest.expiration_time();
        this.issue_time = couponUpdateRequest.issue_time();
    }
}
