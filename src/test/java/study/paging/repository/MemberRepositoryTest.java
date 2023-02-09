package study.paging.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.paging.entity.Member;
import study.paging.entity.Reserve;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {
    @Autowired
    EntityManager em;
    @Test
    public void testMember() {
        Member member = Member.addMember("찬우","asd","asdf");
        Member member1 = Member.addMember("훈일","qwer","123");
        Member member2 = Member.addMember("성호","zxcv","123");

        em.persist(member);
        em.persist(member1);
        em.persist(member2);

        Reserve reserve1 = Reserve.createReserve(member, "hi", "hello1");
        Reserve reserve2 = Reserve.createReserve(member, "hi", "hello2");
        Reserve reserve3 = Reserve.createReserve(member, "hi", "hello3");
        Reserve reserve4 = Reserve.createReserve(member, "hi", "hello4");

        em.persist(reserve1);
        em.persist(reserve2);
        em.persist(reserve3);
        em.persist(reserve4);

        em.flush();
        em.clear();


    }

}