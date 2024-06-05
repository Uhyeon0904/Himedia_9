package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    private Pokemon pokemon;

//    @Autowired
    /* 생성자 주입 방식이 하나 일 때 @AutoWired 어노테이션을 생략해도 문제가 없다.
    * 두 개 이상일 경우 명시적으로 작성하여 우선 순위를 표시 할 수 있다.*/
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
