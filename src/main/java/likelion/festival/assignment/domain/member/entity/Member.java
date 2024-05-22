package likelion.festival.assignment.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import likelion.festival.assignment.domain.couponholder.entity.CouponHolder;
import likelion.festival.assignment.domain.member.dto.request.MemberUpdateRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name="age")
    private int age;

    @Column(name="is_account_expired")
    private boolean is_account_expired;

    @Column(name="is_account_locked")
    private boolean is_account_locked;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    @JsonIgnore // JSON 직렬화 과정에서 무시
    private List<CouponHolder> couponHolders;


    @Builder
    public Member(String email, String password, String name, Role role, int age, boolean is_account_expired, boolean is_account_locked){
        this.email = email;
        this.password = password;
        this.name = name;
        this.role=role;
        this.age = age;
        this.is_account_expired = is_account_expired;
        this.is_account_locked = is_account_locked;
    }

    public void updateMember(MemberUpdateRequest memberUpdateRequest){
        this.email = memberUpdateRequest.email();
        this.password = memberUpdateRequest.password();
        this.name = memberUpdateRequest.name();
        this.role = memberUpdateRequest.role();
        this.age = memberUpdateRequest.age();
    }
}
