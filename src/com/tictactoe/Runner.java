package com.tictactoe;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(5);    //velikost pole
        game.init();



        TicTacToeGame.FieldValue player = TicTacToeGame.FieldValue.O;

        Scanner scanner = new Scanner(System.in);
        while (true) {

            game.printBoard();

            System.out.println("Input coordinates:");           //zadani koordinatu pro hrace
            String input = scanner.nextLine();
            if (input.equals("exit")) {                                 //pri zadani exit se hra ukonci
                break;
            }

            String[] inputNumbers = input.split(" ");                   //nutna mezera mezi cisli v input
            if (inputNumbers.length != 2) {                                     //kdyz nejsou zadana dve cisla tak je neplatny vstup
                System.out.println("Invalid input!");
                continue;
            }


            Integer x = parseInt(inputNumbers[0]);                              // prvni cislo ([0]) je osa x a druhe cislo  ([1]) je osa y
            Integer y = parseInt(inputNumbers[1]);

            if (x == null || y == null) {                                       //jakmile nezadas do x nebo y cislo tak je to neplatny vstup
                System.out.println("Invalid input!");
                continue;
            }

            if (game.getFieldSize()<=x || game.getFieldSize()<=y) {             //jestlize je x nebo y vetsi jak velikost hraciho pole tak je neplatny vstup
                System.out.println("Invalid input!");
                continue;
            }


            if (player.equals(TicTacToeGame.FieldValue.O)) {                    //
                if( game.setField(TicTacToeGame.FieldValue.O, x, y)){
                    if(game.winner()){
                        System.out.println("winner is " + player );
                        break;
                    }
                    player = TicTacToeGame.FieldValue.X;
                }else{
                    System.out.println("wrong field");
                    continue;
                }


            }else {
                if (game.setField(TicTacToeGame.FieldValue.X, x, y)) {
                    if(game.winner()){
                        System.out.println("winner is " + player );
                        break;
                    }
                    player = TicTacToeGame.FieldValue.O;
                } else {
                    System.out.println("wrong field");                          //osetreni pri zadani x na obsazene pole
                    continue;
                }
            }
        }
    }

    public static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
