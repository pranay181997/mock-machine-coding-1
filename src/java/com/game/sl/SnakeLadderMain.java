package com.game.sl;

import com.game.sl.Service.SnakeLadderService;
import com.game.sl.model.Dice;
import com.game.sl.model.Ladder;
import com.game.sl.model.Player;
import com.game.sl.model.Snake;
import com.game.sl.model.SnakeLadderBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author : Pranay Kumar, Date: 29/6/21, 5:33 PM
 */
public class SnakeLadderMain {

    public static void main(String[] args) {
//        System.out.println("Pranay");
        List<Player> players = new ArrayList<>();
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        Dice dice = new Dice();
        Scanner input = new Scanner(System.in);
        int numberOfPlayers = input.nextInt();
        int count = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = input.nextLine();
            players.add(new Player(name, String.valueOf(count)));
            count++;
        }
        int numberOfSnake = input.nextInt();
        for (int i = 0; i < numberOfSnake; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            snakes.add(new Snake(start, end));
        }
        int numberOfLadder = input.nextInt();
        for (int i = 0; i < numberOfSnake; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            ladders.add(new Ladder(start, end));
        }

        SnakeLadderBoard snakeLadderBoard=new SnakeLadderBoard(null,ladders,snakes,dice,players);

        SnakeLadderService snakeLadderService=new SnakeLadderService(snakeLadderBoard);
//        System.out.println("Pranay");

        snakeLadderService.startGame();
    }
}
