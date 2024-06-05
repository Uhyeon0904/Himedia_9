package com.ohgiraffers.section03.annotconfig.sub01.java;

import org.springframework.context.annotation.ComponentScan;

/* @ComponentScan: 자기랑 같은 패키지에 있는 클래스를 스캔해서 컴포넌트 어노테이션이 있는 것을 bean으로 설정
*   basePackages = "com.ohgiraffers": 지정 경로 하위에 모든 클래스를 스캔*/

/* ComponentScan
* base package로 설정 된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록하는 기능
* base package를 설정하지 않으면 기본적으로 설정 파일과 동일한 패키지에 있는 bean만 탐색한다.
* @Component 어노테이션이 작성 된 클래스를 인식하여 bean으로 등록한다.*/
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {
}
