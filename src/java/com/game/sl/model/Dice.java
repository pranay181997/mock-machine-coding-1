package com.game.sl.model;

import java.util.Random;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:48 PM
 */
public class Dice {
    Integer diceMaximumNumber;

    public Integer getDiceMaximumNumber() {
        return diceMaximumNumber;
    }

    public Dice setDiceMaximumNumber(Integer diceMaximumNumber) {
        this.diceMaximumNumber = diceMaximumNumber;
        return this;
    }

    public Integer rollDice() {
        return new Random().nextInt(6) + 1;
    }
}
