package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application2 {
    public static void main(String[] args) {

        /* [ 와일드 카드 ]
        제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때, 그 객체의 타입 변수를 제한할 수 있다.
        <?> : 제한없음
        <? extends Type> : 와일드 카드의 상한 제한( Type 과 Type 의 후손을 이용해 생성한 인스턴스만 인자로 사용
        <? super Type> : 와일드 카드의 하한 제한( Type 과 Type 의 부모를 이용해 생성한 인스턴스만 인자로 사용 */

        WildCardFarm wildCardFarm = new WildCardFarm();

        /* <?> */
//        wildCardFarm.anyType(new RabbitFarm<Mammal>(new Mammal()));
//        wildCardFarm.anyType(new RabbitFarm<Reptile>(new  Reptile()));

        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        /* <? extends Bunny> */
//        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        /* <? super Bunny> */
//        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

    }
}
