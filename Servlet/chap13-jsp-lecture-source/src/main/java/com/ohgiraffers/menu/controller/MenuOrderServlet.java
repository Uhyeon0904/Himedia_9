package com.ohgiraffers.menu.controller;

import com.ohgiraffers.menu.model.service.MenuPriceCalculator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String menuName = request.getParameter("menuName");
        int amount = Integer.parseInt(request.getParameter("amount"));

        System.out.println("menuName = " + menuName);
        System.out.println("amount = " + amount);

        int orderPrice = new MenuPriceCalculator().calcOrderPrice(menuName, amount);

        request.setAttribute("menuName", menuName);
        request.setAttribute("amount", amount);
        request.setAttribute("orderPrice", orderPrice);

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(request, response);
    }
}
