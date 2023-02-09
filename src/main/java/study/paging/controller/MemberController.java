package study.paging.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.paging.dto.MemberDto;
import study.paging.entity.Member;
import study.paging.repository.MemberRepository;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;



    @GetMapping("/member/get-reserve")
    public List<MemberDto> memberList(){
        List<Member> members = memberRepository.findAllReserve();
        List<MemberDto> collect = members.stream().map(m -> new MemberDto(m))
                .collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/member/get-reserve1")
    public List<MemberDto> memberList1(){
        List<Member> members = memberRepository.findAllReserve1();
        List<MemberDto> collect = members.stream().map(m -> new MemberDto(m))
                .collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/member/get-reserve2")
    public List<MemberDto> memberList2(@RequestParam(value = "offset",defaultValue = "0") int offset,
                                       @RequestParam(value = "limit",defaultValue = "100") int limit){
        List<Member> members = memberRepository.findAllReserve2(offset,limit);
        List<MemberDto> collect = members.stream().map(m -> new MemberDto(m))
                .collect(Collectors.toList());
        return collect;
    }


}
