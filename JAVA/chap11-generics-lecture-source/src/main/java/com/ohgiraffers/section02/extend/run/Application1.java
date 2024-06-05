package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.Bunny;
import com.ohgiraffers.section02.extend.DrunkenBunny;
import com.ohgiraffers.section02.extend.Rabbit;
import com.ohgiraffers.section02.extend.RabbitFarm;

public class Application1 {
    public static void main(String[] args) {
        /* 토끼의 후손이거나 토끼인 경우에만 타입으로 사용 가능
        그 외의 타입으로 타입 지정시 컴파일 단계에서 에러를 발생 */
//        RabbitFarm<Animal> rabbitFarm = new RabbitFarm<>();
//        RabbitFarm<Mammal> rabbitFarm = new RabbitFarm<Mammal>();
//        RabbitFarm<Snake> rabbitFarm = new RabbitFarm<Snake>();
        RabbitFarm<Rabbit> rabbitFarm1 = new RabbitFarm<>();
        RabbitFarm<Bunny> rabbitFarm2 = new RabbitFarm<Bunny>();
        RabbitFarm<DrunkenBunny> rabbitFarm3 = new RabbitFarm<>();

//        rabbitFarm1.setAnimal(new Snake());
        System.out.println("=====================================");
        rabbitFarm1.setAnimal(new Rabbit());
//        (rabbitFarm1.getAnimal()).cry();
        /* 제네릭을 사용해서 올바른 타입을 타입변수로 지정하는 경우
        인스턴스 내부에 있는 타입 자제가 Rabbit 타입을 가지고있는 것이 보장되어 있기 때문에 형변환 생략 가능 */
        rabbitFarm1.getAnimal().cry();

        System.out.println("=====================================");
        rabbitFarm2.setAnimal(new Bunny());
        rabbitFarm2.getAnimal().cry();

        System.out.println("=====================================");
        rabbitFarm3.setAnimal(new DrunkenBunny());
        rabbitFarm3.getAnimal().cry();

        System.out.println("=====================================");
    }
}
