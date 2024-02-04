package dev.syntax.aop;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    // 전체 User 목록 조회 메서드
    public void getUsers() {
        //DB로부터 받아온 User 정보
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Tom"));
        users.add(new User(2, "Jerry"));

//        System.out.println("전체 User : " + users);
    }
}
