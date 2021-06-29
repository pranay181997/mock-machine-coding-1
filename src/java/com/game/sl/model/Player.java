package com.game.sl.model;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:48 PM
 */
public class Player {
    String name;
    String Id;

    public Player(String name, String id) {
        this.name = name;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return Id;
    }

    public Player setId(String id) {
        Id = id;
        return this;
    }
}
