package study.paging.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.paging.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;


    // 컬렉션 페치 조인
    public List<Member> findAllReserve(){
        return em.createQuery("select m from Member m" +
                " join fetch m.memberInfo mf" +
                " join fetch m.reserveList ri",Member.class).getResultList();
    }


    // 컬렉션 페치 조인 distinct
    public List<Member> findAllReserve1(){
        return em.createQuery("select distinct m from Member m" +
                " join fetch m.memberInfo mf" +
                " join fetch m.reserveList ri",Member.class).getResultList();
    }


    // default_batch_fetch_size
    public List<Member> findAllReserve2(int offset, int limit){
        return em.createQuery("select m from Member m" +
                " join fetch m.memberInfo mf",Member.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }


}
