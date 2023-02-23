package study.paging.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberInfo {

    @Id @GeneratedValue
    @Column(name = "memeber_info_id")
    private Long id;

    private String address;
    
    private String nikname;

    public MemberInfo(String address) {
        this.address = address;
    }
}
