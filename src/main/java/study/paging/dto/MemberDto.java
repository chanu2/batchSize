package study.paging.dto;

import lombok.Getter;
import lombok.Setter;

import study.paging.entity.Member;



import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MemberDto {

    private Long memberId;
    private String username;
    private String loginId;
    private String password;
    private String address;
    private List<ReserveDto> reserveList;
    public MemberDto(Member member){

        memberId = member.getId();
        username = member.getUsername();
        loginId = member.getLoginId();
        password = member.getPassword();
        address = member.getMemberInfo().getAddress();
        reserveList = member.getReserveList().stream()
                .map(reserve -> new ReserveDto(reserve))
                .collect(Collectors.toList());

    }
}
