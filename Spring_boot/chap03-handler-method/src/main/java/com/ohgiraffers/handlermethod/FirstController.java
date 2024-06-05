package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")

// 세션에 담길 키를 설정해준다.
//@SessionAttributes("id"), 첫 번째 방법만 적용
public class FirstController {

    @GetMapping("regist")
    /* 반환 값을 void로 설정하면 요청 주소가 view의 이름이 된다.( regist )*/
    public void regist() {}

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + " 을(를) 신규 메뉴 목록의 "
                + categoryCode + "번 카테고리에 " + price + "원으로 등록 하셨습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {}

    /* @RequestParam 요청 파라미터 전달 받기
    * 요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션으로 매개변수 앞에 작성한다.
    * form의 name 속성 값과 매개변수의 이름이 다른 경우 @RequestParam("name"을 설정하면 된다.
    * 값이 넘어오지 않는 경우 defaultValue를 이용해 기본 값을 설정해줄 수 있다.*/
    @PostMapping("modify")
    /* @RequestParam("modifyName") String name: 매개변수의 이름을 변경하고자 할 때
    * 어노테이션 이름을 명시해 줘야 한다.
    * RequestParam 생략이 가능하기는 하지만 명시적으로 적어주는 것이 좋다.
    * defaultValue로 아무것도 입력하지 않았을 경우 디폴트 값이 적용된다. */
    public String modifyMenuPrice(Model model, @RequestParam("modifyName") String name,
                                  @RequestParam(defaultValue = "0") int modifyPrice) {

        String message = name + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* 파라미터가 여러 개 인 경우 맵으로 한번에 처리할 수 있다.
    * 이 때 맵의 키는 form의 name 속성 값이 된다. */
    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {
        String modifyMenu = parameters.get("modifyName2");
        String modifyPrice = parameters.get("modifyPrice2");

        String message = "메뉴의 이름을 " + modifyMenu + "으로, 가격을 " + modifyPrice + "원으로 변경함";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search() {}

    /* @ModelAttribute 이용하는 방법
    * DTO같은 모델을 커맨드 객체를 생성하여 매개변수로 전달해 준 뒤 해당 인스턴스를 model에 담는다.
    * 경우에 따라 폼에서 입력한 값을 다음 화면으로 바로 전달해야 하는 경우 유용하게 사용할 수 있다.
    * ModelAttribute("모델에담을 key값")을 지정할 수 있으며, 지정하지 않으면 타입의 앞글자를 소문자로 한 네이밍
    * 규칙을 따른다. menuDTO로 담긴다. */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menuDTO) {
        System.out.println("menuDTO = " + menuDTO);

        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {}

    /* HttpSession을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다. */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {
        session.setAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {

        session.invalidate();

        return "first/loginResult";
    }

    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {
        model.addAttribute("id", id);

        return "first/loginResult";
    }

    /* SessionAttribute로 등록된 값은 session의 상태를 관리하는 SessionStatus의 setComplete() 메소드를
    * 호출해야 사용이 만료된다. */
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "first/loginResult";
    }
}
