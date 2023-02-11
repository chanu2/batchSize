package study.paging;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.paging.entity.Member;
import study.paging.entity.MemberInfo;
import study.paging.entity.Reserve;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component  // 스프링빈 등록
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct  //bean이 여러 번 초기화되는 걸 방지할 수 있다.
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor // 생성자 주입
    static class InitService {

        private final EntityManager em;


        public void dbInit1() {

            MemberInfo memberInfo = new MemberInfo("서울");
            MemberInfo memberInfo1 = new MemberInfo("경기");
           MemberInfo memberInfo2 = new MemberInfo("천안");
           MemberInfo memberInfo3 = new MemberInfo("수원");

            em.persist(memberInfo);
            em.persist(memberInfo1);
            em.persist(memberInfo2);
            em.persist(memberInfo3);

            Member member = Member.addMember("찬우","qwer","1234",memberInfo);
            Member member1 = Member.addMember("훈일","asdf","1234",memberInfo1);
            Member member2 = Member.addMember("성호","zxcv","1234",memberInfo2);
            Member member3 = Member.addMember("준장","uiop","1234",memberInfo3);

            em.persist(member);
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            //찬우가 방을 3개 만듬
            Reserve reserve1 = Reserve.createReserve(member, "A", "helloA");
            Reserve reserve2 = Reserve.createReserve(member, "B", "helloB");
            Reserve reserve3 = Reserve.createReserve(member, "C", "helloC");


            //훈일이가 방을 2개 만듬
            Reserve reserve4 = Reserve.createReserve(member1, "D", "helloD");
            Reserve reserve5 = Reserve.createReserve(member1, "E", "helloE");

            //성호가 만든방
            Reserve reserve6 = Reserve.createReserve(member2, "F", "helloF");

            // 준장이가 방 1개를 만듬
            Reserve reserve7 = Reserve.createReserve(member3, "G", "helloG");

            em.persist(reserve1);
            em.persist(reserve2);
            em.persist(reserve3);
            em.persist(reserve4);
            em.persist(reserve5);
            em.persist(reserve6);
            em.persist(reserve7);

            em.flush();

            em.clear();


        }


    }
}