package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/* 컨트롤러 어노테이션이 달린 클래스만 Mapping 어노테이션을 사용할 수 있다. */
@RequestMapping("/order/*")
/* 앞에가 order가 오고 뒤에는 뭐가 오든 상관 없이 실행 하겠다. */
public class ClassMappingTestController {

    // Class 레벨 매핑을 했을 때
    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message",
                "GET 방식의 주문 등록용 핸들러 메소드 호출함");

        return "mappingResult";
    }

    // 여러 개일 경우 중괄호를 통해 처리 가능
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDeleteOrder(Model model) {

        model.addAttribute("message",
                "POST 방식의 주문 수중, 삭제 공통 핸들러 메소드 호출함");

        return "mappingResult";
    }

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable int orderNo) {
        /* @PathVariable: 요청 path로부터 변수를 받아올 수 있다.
         * path variable로 전달 되는 {변수명} 값은 반드시 매개변수명과 동일해야 한다.
         * 만약 동일하지 않으면 @PathVariable("이름")을 설정해 주어야 한다.*/

        /* parsing 불가능한 PathVariable이 전달되면 400번 에러가 발생한다.
        *  PathVariable이 없으면 해당 핸들러 메소드를 찾지 못한다. */
        model.addAttribute("message",
                orderNo + "주문 상세 내용 조회용 핸들러 메소드 호출");

        return "mappingResult";
    }

    /* 아무런 URL을 설정하지 않으면 요청 처리에 대한 핸들러 메소드가 준비되지 않았을 때 해당 메소드를 호출 */
    @RequestMapping
    public String otherRequest(Model model) {
        model.addAttribute("message",
                "order 요청이긴 하지만 다른 기능은 준비중...");

        return "mappingResult";
    }
}
