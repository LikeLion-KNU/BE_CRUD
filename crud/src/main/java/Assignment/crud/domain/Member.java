package Assignment.crud.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    private int age;

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    @OneToMany(mappedBy = "member")
    private List<CouponHolders> couponHolders;

}
