package com.osckorea.oscboardjdbcoriginal.dao;

import com.osckorea.oscboardjdbcoriginal.domain.Board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BoardDao {

    public Connection getConnection() {
        Connection con = null;
        String server = "localhost:3306";
        String database = "springjdbc";
        String option = "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
        String userName = "root";
        String password = "1q2w3e4r";

        // 드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error" + e.getMessage());
        }

        // 드라이버 연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + option, userName, password);
            System.out.println("정상 연결");
        } catch (SQLException e) {
            System.err.println("오류" + e.getMessage());
        }
        return con;
    }

    // 드라이버 연결해제
    public void closeConnection(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
        }
    }

    // Create Read Update Delete
    public void addBoard(Board board) throws SQLException {
        String query = "INSERT INTO BOARD (id, title, contents), VALUES(?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, board.getTitle());
        pstmt.setString(2, board.getContents());
        pstmt.executeUpdate();
    }
}


