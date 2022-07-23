import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();

    }

    static void partOne() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        String[] crabs = in.nextLine().split(",");
        
        HashSet<String> uniqePositions = new HashSet<>();
        uniqePositions.addAll(Arrays.asList(crabs));

        int bestPos = -1;
        int fuelBestPos = -1;

        for (String v : uniqePositions) {
            int sumFuel = 0;
            int pos = Integer.parseInt(v);
            for (int j=0; j < crabs.length; j++) {
                int crab = Integer.parseInt(crabs[j]);
                sumFuel += Math.abs(pos - crab);
            }
            if (fuelBestPos == -1 || fuelBestPos > sumFuel) {
                fuelBestPos = sumFuel;
                bestPos = pos;
            }
        }

        System.out.println("Best position: " + bestPos + ", amount of fuel: " + fuelBestPos);

    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        String[] crabs = in.nextLine().split(",");
        
        int low = Integer.parseInt(crabs[0]);
        int high = Integer.parseInt(crabs[0]);

        for (int i=1; i < crabs.length; i++) {
            int crab = Integer.parseInt(crabs[i]);
            if (crab < low) {
                low = crab;
            }
            if (crab > high) {
                high = crab;
            }
        }

        int bestPos = -1;
        int fuelBestPos = -1;

        for (int k=low; k <= high; k++) {
            int sumFuel = 0;
            for (int j=0; j < crabs.length; j++) {
                int crab = Integer.parseInt(crabs[j]);
                sumFuel += fuelUsage(Math.abs(k - crab));
            }
            if (fuelBestPos == -1 || fuelBestPos > sumFuel) {
                fuelBestPos = sumFuel;
                bestPos = k;
            }
        }

        System.out.println("Best position: " + bestPos + ", amount of fuel: " + fuelBestPos);
    }

    static int fuelUsage(int n) {
        if (n == 0) {
            return 0;
        }
        return n + fuelUsage(n-1);
    }


}