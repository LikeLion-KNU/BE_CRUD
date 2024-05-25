package domain;

import dto.member.MemberUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    private String email;
    private String password;
    private Role role;
    private String name;
    private int age;
    private boolean isAccountExpired;
    private boolean isAccountLocked;

    @OneToMany(mappedBy = "member")
    private List<CouponHolders> couponHolders;

    public void update(MemberUpdateRequestDTO memberUpdateRequestDTO){
        this.age = memberUpdateRequestDTO.getAge();
        this.name = memberUpdateRequestDTO.getName();
        this.email = memberUpdateRequestDTO.getEmail();
        this.password = memberUpdateRequestDTO.getPassword();
    }
}
