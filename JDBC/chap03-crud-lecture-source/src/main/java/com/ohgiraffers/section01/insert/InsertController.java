package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class InsertController {

    public int insertMenu(MenuDTO menuDTO) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int resulrt = 0;

        Properties prop = new Properties();
        // 파일을 읽어오려고 만듦

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/" +
                    "mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuDTO.getMenuName());
            pstmt.setInt(2, menuDTO.getMenuPrice());
            pstmt.setInt(3, menuDTO.getCategoryCode());
            pstmt.setString(4, menuDTO.getOrderableStatus());
            // setter, getter를 사용하려면 메소드의 매개변수에 MenuDTO 타입을 선언해줘야한다.

            resulrt = pstmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }
        return resulrt;
    }
}
