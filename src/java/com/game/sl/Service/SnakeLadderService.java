package com.game.sl.Service;

import com.game.sl.model.Ladder;
import com.game.sl.model.Player;
import com.game.sl.model.Snake;
import com.game.sl.model.SnakeLadderBoard;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:50 PM
 */
public class SnakeLadderService {
    SnakeLadderBoard snakeLadderBoard;

    public SnakeLadderService(SnakeLadderBoard snakeLadderBoard) {
        this.snakeLadderBoard = snakeLadderBoard;
    }

    public int getPositionIfSnakeBite(Integer currentPosition) {
        if (snakeLadderBoard == null) {
            throw new RuntimeException("No SnakeLadderBoardFound");
        }

        int newPosition = currentPosition;
        List<Snake> snakes = snakeLadderBoard.getSnakes();
        if (snakes.isEmpty()) {
            return newPosition;
        }
        for (Snake snake : snakes) {
            if (snake.getStart() == newPosition) {
                newPosition = snake.getEnd();
            }
        }
        return newPosition;
    }

    public int getIfPlayersClimbTheLadder(Integer currentPosition) {
        if (snakeLadderBoard == null) {
            throw new RuntimeException("No SnakeLadderBoardFound");
        }

        int newPosition = currentPosition;
        List<Ladder> ladders = snakeLadderBoard.getLadders();
        if (ladders.isEmpty()) {
            return newPosition;
        }
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPosition) {
                newPosition = ladder.getEnd();
            }
        }
        return newPosition;
    }

    public boolean isPlayeWon(Integer currentPosition) {
        if (snakeLadderBoard == null) {
            throw new RuntimeException("No snakeLadderBoardFound");
        }
        return snakeLadderBoard.getBoardSize().equals(currentPosition);
    }

    public void startGame() {
        if (snakeLadderBoard == null) {
            throw new RuntimeException("No snakeLadderBoardFound");
        }
        snakeLadderBoard.updateIntialPositionOfPlayers();
        Queue<Player> players = new LinkedList<>(snakeLadderBoard.getPlayers());

        while (!players.isEmpty()) {
            Player player = players.poll();
            int currentPosition = snakeLadderBoard.getPlayersCurrentPosition().get(player);
            if (isPlayeWon(currentPosition)) {
                System.out.println("Player " + player.getName() + " won the game.");
                continue;
            }
            if (currentPosition != getPositionIfSnakeBite(currentPosition)) {
                currentPosition = getPositionIfSnakeBite(currentPosition);
                snakeLadderBoard.getPlayersCurrentPosition().put(player, currentPosition);
                players.add(player);
            } else if (currentPosition != getIfPlayersClimbTheLadder(currentPosition)) {
                currentPosition = getIfPlayersClimbTheLadder(currentPosition);
                snakeLadderBoard.getPlayersCurrentPosition().put(player, currentPosition);
                players.add(player);
            } else {
                int numberAfterRollingTheDice = snakeLadderBoard.getDice().rollDice();
                if (numberAfterRollingTheDice + currentPosition > 100) {
                    players.add(player);
                } else {
                    currentPosition = numberAfterRollingTheDice + currentPosition;
                    System.out.println(player.getName() + " rolled a" + numberAfterRollingTheDice + " and moved from" + snakeLadderBoard.getPlayersCurrentPosition().get(player) + " to " + currentPosition);
                    snakeLadderBoard.getPlayersCurrentPosition().put(player, currentPosition);
                    players.add(player);
                }
            }
        }
    }


}
