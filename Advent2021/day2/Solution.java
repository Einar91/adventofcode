import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();

    }

    static void partOne() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        int h = 0;
        int d = 0;

        while(in.hasNextLine()) {
            String[] line = in.nextLine().split(" "); 
            String op = line[0];
            int X = Integer.parseInt(line[1]);
            
            if (op.equals("forward")) {
                h += X;
            } else if (op.equals("down")) {
                d += X;
            } else if (op.equals("up")) {
                d -= X;
            }
        }
        System.out.println("Calculated position: " + (h*d));

    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        int h = 0;
        int d = 0;
        int aim = 0;

        while(in.hasNextLine()) {
            String[] line = in.nextLine().split(" "); 
            String op = line[0];
            int X = Integer.parseInt(line[1]);
            
            if (op.equals("forward")) {
                h += X;
                d += aim * X;
            } else if (op.equals("down")) {
                aim += X;
            } else if (op.equals("up")) {
                aim -= X;
            }
        }
        System.out.println("Calculated position: " + (h*d));

    }
}