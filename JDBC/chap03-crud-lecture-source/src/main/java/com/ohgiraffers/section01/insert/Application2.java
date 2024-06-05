package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매여부를 입력 받기 (Scanner 이용) */

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 이름 > ");
        String menuName = sc.next();
        System.out.print("가격 > ");
        int menuPrice = sc.nextInt();
        System.out.print("카테고리 코드 > ");
        int categoryCode = sc.nextInt();
        System.out.print("판매 여부 (Y/N) > ");
        // 버퍼에 개행문자가 남아 있기 때문에 제거
        String orderableStatus = sc.next().toUpperCase();

        /* MenuDTO 객체를 생성하여 입력받은 값으로 setting */
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuName(menuName);
        menuDTO.setMenuPrice(menuPrice);
        menuDTO.setCategoryCode(categoryCode);
        menuDTO.setOrderableStatus(orderableStatus);

        /* InsertController의 insertMenu() 메소드 호출 */
        InsertController ic = new InsertController();
        int result = ic.insertMenu(menuDTO);

        /* insert 결과에 따라서 성공이면 메뉴 등록 성공, 실패이면 '메뉴 등록 실패!' 출력 */
        if (result > 0) {
            System.out.println("메뉴 등록 성공");
        } else {
            System.out.println("메뉴 등록 실패");
        }
    }
}
