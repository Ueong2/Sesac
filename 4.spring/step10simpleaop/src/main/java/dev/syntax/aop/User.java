package dev.syntax.aop;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
