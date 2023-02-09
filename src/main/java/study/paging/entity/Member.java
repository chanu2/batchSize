package study.paging.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String loginId;

    @OneToOne
    @JoinColumn(name = "member_info_id")
    private MemberInfo memberInfo;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Reserve> reserveList = new ArrayList<>();


    //==생성 메서드==//
    public static Member addMember(String username, String loginId, String password , MemberInfo memberInfo){

        Member member = new Member();
        member.setUsername(username);
        member.setLoginId(loginId);
        member.setPassword(password);
        member.setMemberInfo(memberInfo);
        return member;
    }



}
