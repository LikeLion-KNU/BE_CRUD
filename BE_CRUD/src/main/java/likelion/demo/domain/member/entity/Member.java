package likelion.demo.domain.member.entity;

import jakarta.persistence.*;
import likelion.demo.domain.holder.entity.CouponHolder;
import likelion.demo.domain.member.dto.request.MemberUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor()
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;

    @Column(name="is_account_expired")
    private Boolean is_account_expired;
    @Column(name="is_account_locked")
    private Boolean is_account_locked;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<CouponHolder> couponHolders =new ArrayList<>();

    @Builder
    public Member(String email,String password,String name,int age,Role role){
        this.email=email;
        this.password =password;
        this.name=name;
        this.age =age;
        this.role=role;
        this.is_account_expired = true;
        this.is_account_locked = true;
    }

    public void update(MemberUpdateRequest memberUpdateRequest){
        this.name =memberUpdateRequest.name();
        this.age = memberUpdateRequest.age();

    }

    // 연관 관계 편의 메소드
/*
    public void addCouponHolderMember(CouponHolder couponHolder){
        couponHolders.add(couponHolder);
        couponHolder.setMember(this);
    }
*/

        /*// 연관 관계 편의 메소드
        public void addImageList(Image image){
            images.add(image);
            image.setBoard(this);
        }    }
*/

}
