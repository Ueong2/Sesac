package dev.spring.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;

    private String name;

    private int level;

    @Builder
    public User(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }
}