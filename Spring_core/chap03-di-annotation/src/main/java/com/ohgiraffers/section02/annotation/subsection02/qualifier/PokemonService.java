package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    // 필드 주입 방식
//    @Autowired
//    @Qualifier("pikachu")
    /* Pikachu 클래스에 @Component 어노테이션의 이름을 지정해 주지 않아서, 클래스 이름의 첫 글자를 소문자로
    * 변경 한 pikachu로 bean 이름을 자동으로 지정해 준다. */
    private Pokemon pokemon;

    // 생성자 주입 방식
    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
