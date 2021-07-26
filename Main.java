package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        stateDetermineSuch();


    }


    private static void stateDetermineSuch() {

        boolean xWin = false;
        boolean oWin = false;
        int countStep = 1;
        boolean repeat = true;
        // getting the grid info
        String[][] grid = new String[3][3];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the cells: ");
        String inputXO = "_________";
        int value = 0;

        //getting all the info to the grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputXO.charAt(value) == '_') {
                    grid[i][j] = " ";
                } else {
                    grid[i][j] = inputXO.substring(value, value + 1);
                }
                value++;
            }
        }

        // outputting the grid
        girdOutput(inputXO);


        //enter the info
        while (repeat) {
            System.out.print("Enter the coordinates: ");
            String inputCoor = scan.nextLine();
            int firstCoor = Integer.parseInt(inputCoor.substring(0, 1));
            int secondCoor = Integer.parseInt(inputCoor.substring(2));

            //checking the grid and update
            if (inputCoor.matches("[0-9]*$")) {
                System.out.println("You should enter numbers!");
            } else if ((firstCoor > 3 || firstCoor < 0) || secondCoor > 3 || secondCoor < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (!grid[firstCoor - 1][secondCoor - 1].equals(" ")) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {

                if (countStep % 2 != 0) {
                    grid[firstCoor - 1][secondCoor - 1] = "X";
                } else {
                    grid[firstCoor - 1][secondCoor - 1] = "O";
                }


                System.out.println("---------");
                for (int x = 0; x < 3; x++) {
                    System.out.print("| ");
                    for (int y = 0; y < 3; y++) {
                        System.out.print(grid[x][y] + " ");
                    }
                    System.out.println("|");
                }
                System.out.println("---------");


                if (winCond(grid) == 1) {
                    System.out.println("X wins");
                    repeat = false;

                } else if (winCond(grid) == 0) {
                    System.out.println("O wins");
                    repeat = false;

                } else
                    if (countXO(grid) == 9 && winCond(grid) == 2 )
                    {
                    System.out.println("Draw");
                    repeat = false;

                }

                countStep++;


            }
        }

    }

    private static int winCond(String[][]grid){
        boolean xWin = false;
        boolean oWin = false;

        for (int i = 0; i < 3; i++) {
            if (grid[i][0].equals(grid[i][1]) &&grid[i][1].equals(grid[i][2])){
                if (grid[i][1].equals("X")) {
                    xWin = true;
                    return 1;
                } else if (grid[i][1].equals("O")) {
                    oWin = true;
                    return 0;
                }
            }
        }
        //cols
        for(int j = 0; j < 3; j++){
            if (grid[0][j].equals(grid[1][j]) &&grid[1][j].equals(grid[2][j])){
                if (grid[1][j].equals("X")) {
                    xWin = true;
                    return 1;
                } else if (grid[1][j].equals("O")) {
                    oWin = true;
                    return 0;
                }
            }
        }
        //diagonals
        if ((grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2]) || (grid[0][2].equals(grid[1][1]) && (grid[1][1].equals(grid[2][0]))))) {

            if (grid[1][1].equals("X")) {
                xWin = true;
                return 1;
            } else if (grid[1][1].equals("O")) {
                oWin = true;
                return 0;
            }

        }
        return 2;
    }


    private static int countXO(String[][] table) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals("x") || table[i][j].equals("O")) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countX(String[][] table) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals("X")) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int countO(String[][] table) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals("O")) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void girdOutput(String input) {

        System.out.println("---------");

        System.out.print("|" + " " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.print("\n|" + " " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.print("\n|" + " " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");

        System.out.println("\n---------");
    }


}

