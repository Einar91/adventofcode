import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();

    }

    static void partOne() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        String[] input = in.nextLine().split(",");

        ArrayList<Fish> fishies = new ArrayList<>();
        for (String s : input) {
            fishies.add(new Fish(Integer.parseInt(s), true));
        }

        int days = 80;
        for (int i=0; i < days; i++) {
            int n = fishies.size();
            for (int j=0; j < n; j++) {
                Fish f = fishies.get(j);
                if (f.adult) {
                    f.timer = (f.timer - 1 + 7) % 7;
                    if (f.timer == 6) {
                        fishies.add(new Fish(8, false));
                    }
                } else {
                    if (f.timer == 1) {
                        f.adult = true;
                        f.timer = 0;
                    } else {
                        f.timer = f.timer - 1;
                    }
                }
            }
            //System.out.println("Day " + (i+1) + ": " + fishies);
        }
        System.out.println("" + fishies.size());


    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        String[] input = in.nextLine().split(",");

        HashMap<Integer, BigInteger> fishies = new HashMap<>();
        for (int i=0; i < 7; i++) {
            fishies.put(i, new BigInteger("0"));
        }
        for (String s : input) {
            int fish = Integer.parseInt(s);
            fishies.put(fish, fishies.get(fish).add(BigInteger.valueOf(1)));
        }

        HashMap<Integer, BigInteger> bbyFishies = new HashMap<>();
        bbyFishies.put(6, new BigInteger("0"));
        bbyFishies.put(7, new BigInteger("0"));
        bbyFishies.put(8, new BigInteger("0"));


        int days = 256;
        for (int i=0; i < days; i++) {
            BigInteger timer0 = fishies.get(0);
            BigInteger timer1 = fishies.get(1);
            BigInteger timer2 = fishies.get(2);
            BigInteger timer3 = fishies.get(3);
            BigInteger timer4 = fishies.get(4);
            BigInteger timer5 = fishies.get(5);
            BigInteger timer6 = fishies.get(6);

            fishies.put(0, timer1);
            fishies.put(1, timer2);
            fishies.put(2, timer3);
            fishies.put(3, timer4);
            fishies.put(4, timer5);
            fishies.put(5, timer6);
            fishies.put(6, timer0);


            BigInteger bbyT6 = bbyFishies.get(6);
            BigInteger bbyT7 = bbyFishies.get(7);
            BigInteger bbyT8 = bbyFishies.get(8);

            fishies.put(5, fishies.get(5).add(bbyT6));
            bbyFishies.put(6, bbyT7);
            bbyFishies.put(7, bbyT8);
            bbyFishies.put(8, new BigInteger("0"));

            bbyFishies.put(8, timer0);
            
            //System.out.println("Day " + (i+1) + ": " + fishies);
        }
        BigInteger sum = new BigInteger("0");
        for (BigInteger v : fishies.values()) {
            sum = sum.add(v);
        }
        for (BigInteger v : bbyFishies.values()) {
            sum = sum.add(v);
        }
        System.out.println("" + sum);
    }
}

class Fish {
    public int timer;
    public boolean adult;

    public Fish(int timer, boolean adult) {
        this.timer = timer;
        this.adult = adult;
    }

    public String toString() {
        return "" + timer;
    }
}