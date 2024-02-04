package dev.spring.core.dao;

import dev.spring.core.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
    public int addUser(User user) {
        final String insertQuery = "insert into users (id, level, name) values (?, ?, ?);";
        int affectedRows = 0;

        try (Connection con = DBUtils.getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery);) {
            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, user.getLevel());
            pstmt.setString(3, user.getName());
            affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return affectedRows;
    }
}