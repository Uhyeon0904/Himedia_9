package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerGeneratorTests {

    /* @Test: 테스트를 할 때는 어노테이션을 붙여야한다. */
    /* @DisplayName: 어떤 테스트를 할 것인지 이름을 붙인다. */
    @Test
    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    void testGenerateEntityManagerFactory() {
        // given

        // when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();

        // then
        /* Null이 아니라면 True */
        assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    void testIsGenerateEntityManagerFactorySingletonInstance() {
        // given

        // when
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();

        // then
        /* 1과 2가 같은지 */
        assertEquals(factory1, factory2);
    }

    @Test
    @DisplayName("엔티티 매니저 생성 확인")
    void testGenerateEntityManager() {
        // given
        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        // then
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("엔티티 매니저 스코프 확인")
    void testEntityManagerLifeCycle() {
        // given
        // when
        EntityManager entityManager1 = EntityManagerGenerator.getInstance();
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();
        // then
        assertNotEquals(entityManager1, entityManager2);
    }
}