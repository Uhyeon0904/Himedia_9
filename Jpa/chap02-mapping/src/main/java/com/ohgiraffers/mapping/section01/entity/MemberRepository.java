package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext(name = "entityMember")
    private EntityManager entityManager;

    /* 전달받은 Member 엔티티를 저장한다. */
    public void save(Member member) {
        entityManager.persist(member);
    }

    public String findNameById(String memberId) {
        /* 별칭은 필수 */
        String jpql
                = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" + memberId + "'";
        /* jpql을 수행 후 반환은 String 타입으로 반환 받는다.
        * 단일 결과를 반환 받기 때문에 getSingleResult() 메소드를 사용 */
        return entityManager.createQuery(jpql, String.class).getSingleResult();
    }
}
