import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    static void partOne() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        ArrayList<BingoBoard> alleBrett = new ArrayList<>();
        String[] draws = in.nextLine().split(",");

        while (in.hasNextLine()) {
            if (in.hasNextInt()) {
                int[][] matrise = new int[5][5];
                for (int i=0; i < 5; i++) {
                    for (int j=0; j < 5; j++) {
                        matrise[i][j] = in.nextInt();
                    }
                    if (in.hasNextLine()) {
                        in.nextLine();
                    }
                }
                BingoBoard brett = new BingoBoard(matrise);
                alleBrett.add(brett);
            }
        }

        boolean bingo = false;
        BingoBoard vinner = new BingoBoard(new int[5][5]);
        int lastNum = -1;
        for (String num : draws) {
            for (BingoBoard b : alleBrett) {
                bingo = b.markBoard(Integer.parseInt(num));
                if (bingo) {
                    vinner = b;
                    lastNum = Integer.parseInt(num);
                    break;
                }
            }
            if (bingo) {
                break;
            }
        }
        System.out.println(vinner);
        System.out.println("Score: " + vinner.calculateScore(lastNum));
    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        ArrayList<BingoBoard> alleBrett = new ArrayList<>();
        String[] draws = in.nextLine().split(",");

        while (in.hasNextLine()) {
            if (in.hasNextInt()) {
                int[][] matrise = new int[5][5];
                for (int i=0; i < 5; i++) {
                    for (int j=0; j < 5; j++) {
                        matrise[i][j] = in.nextInt();
                    }
                    if (in.hasNextLine()) {
                        in.nextLine();
                    }
                }
                BingoBoard brett = new BingoBoard(matrise);
                alleBrett.add(brett);
            }
        }

        boolean bingo = false;
        ArrayList<BingoBoard> winnerBoards = new ArrayList<>();
        int lastNum = -1;
        for (String num : draws) {
            for (BingoBoard b : alleBrett) {
                bingo = b.markBoard(Integer.parseInt(num));
                if (bingo) {
                    if(!winnerBoards.contains(b)) {
                        winnerBoards.add(b);
                    }
                }
                if (alleBrett.size() == winnerBoards.size()) {
                    lastNum = Integer.parseInt(num);
                    break;
                }
            }
            if (alleBrett.size() == winnerBoards.size()) {
                break;
            }
        }

        BingoBoard lastWinner = winnerBoards.get(winnerBoards.size()-1);
        System.out.println(lastWinner);
        System.out.println("Score: " + lastWinner.calculateScore(lastNum));
    }
}

class BingoBoard {
    int[][] board;
    int[][] boardMarkings;
    boolean bingo;

    public BingoBoard(int[][] board) {
        this.board = board;
        this.boardMarkings = new int[board.length][board[0].length];
        bingo = false;
    }

    public String toString() {
        String output = "";
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                output = output + board[i][j] + " ";
            }
            output = output + "\n";
        }
        return output;
    }

    public boolean markBoard(int num) {
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] == num) {
                    boardMarkings[i][j] = 1;
                }
            }
        }
        return checkForBingo();
    }

    public boolean checkForBingo() {
        int horizontal = 0;
        int vertical = 0;
        
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (boardMarkings[i][j] == 1) {
                    horizontal++;
                }
                if (boardMarkings[j][i] == 1) {
                    vertical++;
                }
            }
            if (horizontal == 5 || vertical == 5) {
                return true;
            }
            horizontal = 0;
            vertical = 0;
        }
        return false;
    }

    public int calculateScore(int lastDraw) {
        int sumUnmarked = 0;
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (boardMarkings[i][j] == 0) {
                    sumUnmarked += board[i][j];
                }
            }
        }
        return sumUnmarked * lastDraw;
    }
}