package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.section01.insert.InsertController;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* 1. 변경할 메뉴 코드, 이름, 가격을 입력 받기

        2. MenuDTO 객체를 생성하여 입력받은 값으로 setting

        3. UpdateController의 updateMenu() 메소드 호출

        4. update 결과에 따라 성공, 실패 메세지 출력 */

        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴 코드 > ");
        int menuCode = sc.nextInt();
        System.out.print("변경될 메뉴 이름 > ");
        String menuName = sc.next();
        System.out.print("변경될 메뉴 가격 > ");
        int menuPrice = sc.nextInt();

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setMenuCode(menuCode);
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(menuPrice);

        UpdateController uc = new UpdateController();
        uc.updateMenu(menuDTO);
    }
}
