package com.ohgiraffers.section03.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 코드 > ");
        int menuCode = sc.nextInt();

        DeleteController dc = new DeleteController();
        int result = dc.deleteMenu(menuCode);

        if (result > 0 ){
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }
}
