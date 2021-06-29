package com.game.sl.model;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:32 PM
 */
public class Snake {
    int start;
    int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public Snake setStart(int start) {
        this.start = start;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public Snake setEnd(int end) {
        this.end = end;
        return this;
    }
}
