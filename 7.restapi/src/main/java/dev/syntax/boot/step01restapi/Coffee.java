package dev.syntax.boot.step01restapi;

import java.util.UUID;

public class Coffee {
    private String id;
    private String name;
    private String size;

    public Coffee() {
        super();
    }

    public Coffee(String id, String name, String size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Coffee(String name, String size) {
        this(UUID.randomUUID().toString(), name, size);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
