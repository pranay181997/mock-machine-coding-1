package com.game.sl.model;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:49 PM
 */
public class Ladder {
    int start;
    int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public Ladder setStart(int start) {
        this.start = start;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public Ladder setEnd(int end) {
        this.end = end;
        return this;
    }
}
