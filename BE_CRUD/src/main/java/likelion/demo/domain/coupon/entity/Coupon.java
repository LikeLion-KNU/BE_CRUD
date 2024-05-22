package likelion.demo.domain.coupon.entity;

import jakarta.persistence.*;
import likelion.demo.domain.coupon.dto.request.CouponUpdateRequest;
import likelion.demo.domain.holder.entity.CouponHolder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coupon_id")
    private long id;


    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private Type type;

    @Column(name="discount")
    private int discount;

    @Column(name="issue_date")
    private LocalDateTime issueDate;
    @Column(name="expiration_date")
    private LocalDateTime expirationDate;

    @OneToMany(mappedBy = "coupon",cascade = CascadeType.ALL)
    private List<CouponHolder> couponHolders =new ArrayList<>();


    @Builder
    public Coupon(Type type,int discount,LocalDateTime issueDate,LocalDateTime expirationDate){
        this.type =type;
        this.discount =discount;
        this.issueDate=issueDate;
        this.expirationDate=expirationDate;
    }

    public void update(CouponUpdateRequest couponUpdateRequest){
        this.type =couponUpdateRequest.type();
        this.discount =couponUpdateRequest.discount();
        this.issueDate=couponUpdateRequest.issueDate();
        this.expirationDate=couponUpdateRequest.expirationDate();
    }


    // 연관 관계 편의 메소드
    public void addCouponHolderCoupon(CouponHolder couponHolder){
        couponHolders.add(couponHolder);
        couponHolder.setCoupon(this);
    }

}
