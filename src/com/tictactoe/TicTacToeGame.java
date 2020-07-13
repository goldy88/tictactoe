package com.tictactoe;


    public class TicTacToeGame {
        private final int size;
        private final FieldValue[][] gameBoard;

        public TicTacToeGame(int size) {
            this.size = size;                                                           //vytvoreni pole velikosti size x size velikost je zadana ve tride Runner
            this.gameBoard = new FieldValue[size][size];
        }

        public int getFieldSize() {
            return this.size;
        }

        public void init() {
            for (int x = 0; x < size; x++) {                                        //naplneni poli hodnotou empty
                for (int y = 0; y < size; y++) {
                    gameBoard[x][y] = FieldValue.EMPTY;
                }
            }
        }

        public boolean setField(FieldValue value, int x, int y) {
            if (x >= size || y >= size) {
                return false;
            }

            if (gameBoard[x][y] != FieldValue.EMPTY) {
                return false;
            }

            if (gameBoard[x][y] != FieldValue.EMPTY) {
                return false;
            }

            gameBoard[x][y] = value;
            return true;
        }

        public void printBoard() {
            System.out.println("-".repeat(size * 4));                               //oddeleni hraciho pole mezerami z vrchni casti

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    String toPrint = convertToField(gameBoard[x][y]);
                    System.out.print(toPrint + "|");                                //pipe mezi poli
                }
                System.out.println();
            }

            System.out.println("-".repeat(size * 4));                                //oddeleni hraciho pole mezerami ze spodni casti
        }

        private String convertToField(FieldValue value) {
            switch (value) {
                case EMPTY:
                    return " ";
                case O:
                    return "O";
                case X:
                    return "X";
            }

            return "unkown";
        }

        enum FieldValue {
            EMPTY,
            X,
            O
        }


        public boolean winner() {

            int numX = 0;                                   //pocitadlo krizku
            int numO = 0;                                   //pocitadlo kolecek

            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < this.size; y++) {
                    if ((!this.gameBoard[x][y].equals(FieldValue.X) && numX > 0) || !this.gameBoard[x][y].equals(FieldValue.X)) {
                        numX = 0;          //nulovani pocitadla
                    } else {
                        numX++;
                    }
                    if (numX == 3) {
                        return true;
                    }

                    if ((!this.gameBoard[x][y].equals(FieldValue.O) && numO > 0) || !this.gameBoard[x][y].equals(FieldValue.O)) {
                        numO = 0;          //nulovani pocitadla
                    } else {
                        numO++;
                    }
                    if (numO == 3) {
                        return true;
                    }

                }
            }
            return false;
        }
    }





