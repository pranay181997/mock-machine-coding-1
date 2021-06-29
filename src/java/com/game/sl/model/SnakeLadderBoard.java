package com.game.sl.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:49 PM
 */
public class SnakeLadderBoard {
    private static final int FIXED_SIZE = 100;
    Integer boardSize;
    List<Ladder> ladders;
    List<Snake> snakes;
    Dice dice;
    List<Player> players;
    Map<Player, Integer> playersCurrentPosition = new HashMap<>();

    public SnakeLadderBoard(Integer boardSize, List<Ladder> ladders, List<Snake> snakes, Dice dice, List<Player> players) {
        this.boardSize = boardSize == null ? FIXED_SIZE : boardSize;
        this.ladders = ladders;
        this.snakes = snakes;
        this.dice = dice;
        this.players = players;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public SnakeLadderBoard setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
        return this;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public SnakeLadderBoard setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
        return this;
    }

    public Dice getDice() {
        return dice;
    }

    public SnakeLadderBoard setDice(Dice dice) {
        this.dice = dice;
        return this;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public SnakeLadderBoard setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public Map<Player, Integer> getPlayersCurrentPosition() {
        return playersCurrentPosition;
    }

    public SnakeLadderBoard setPlayersCurrentPosition(Map<Player, Integer> playersCurrentPosition) {
        this.playersCurrentPosition = playersCurrentPosition;
        return this;
    }

    public Integer getBoardSize() {
        return boardSize;
    }

    public SnakeLadderBoard setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
        return this;
    }

    public SnakeLadderBoard updateIntialPositionOfPlayers() {
        if (players != null) {
            for (Player player : players) {
                this.playersCurrentPosition.put(player, 0);
            }
        }
        return this;
    }
}
