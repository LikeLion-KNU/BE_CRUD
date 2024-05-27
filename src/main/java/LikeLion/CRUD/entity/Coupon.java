package LikeLion.CRUD.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int discount;
    private LocalDateTime issueDate;
    private LocalDateTime expirationDate;

    // Getters and Setters
}