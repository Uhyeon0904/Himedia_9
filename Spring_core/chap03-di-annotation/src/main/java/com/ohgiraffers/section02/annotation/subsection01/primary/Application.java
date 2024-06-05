package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        PokemonService pokemonService = context.getBean("pokemonServicePrimary", PokemonService.class);

        pokemonService.pokemonAttack();
        /*Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
        No qualifying bean of type 'com.ohgiraffers.section02.common.Pokemon' available:
        expected single matching bean but found 3: charmander,pikachu,squirtle*/
        // 매칭되는 파일을 3개를 찾았다. 라는 오류
    }
}
