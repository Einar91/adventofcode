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

        int lastnumber = in.nextInt(); in.nextLine();
        int num_increase = 0;

        while(in.hasNextLine()) {
            int current_number = in.nextInt(); 
            if (lastnumber < current_number) {
                num_increase++;
            }
            lastnumber = current_number;
        }
        System.out.println(num_increase);
    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        int one = in.nextInt(); in.nextLine();
        int two = in.nextInt(); in.nextLine();
        int three = in.nextInt(); in.nextLine();

        int lastnumber = one + two + three;
        int num_increase = 0;

        while(in.hasNextInt()) {
            one = two;
            two = three;
            three = in.nextInt();
        
            int current_number = one + two + three;

            if (lastnumber < current_number) {
                num_increase++;
            }
            lastnumber = current_number;
        }
        System.out.println(num_increase);
    }
}