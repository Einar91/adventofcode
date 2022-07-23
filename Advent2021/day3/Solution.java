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

        int numBinaryNumbers = 0;

        HashMap<Integer, Integer> bits = new HashMap<>();
        String line = in.nextLine();

        while(in.hasNextLine()) {
            line = in.nextLine(); 
            for (int i=0; i < line.length(); i++) {
                String bit = line.substring(i, i+1);
                if (!bits.containsKey(i)) {
                    bits.put(i, 0);
                }
                if (bit.equals("1")) {
                    bits.put(i, bits.get(i) + 1);
                } else {
                    bits.put(i, bits.get(i) - 1);
                }
            numBinaryNumbers++;
            }
        }

        String gamma_rate = "";
        String epsilon_rate = "";

        for (int value : bits.values()) {
            if (value >= 0) {
                gamma_rate = gamma_rate + "1";
            } else {
                gamma_rate = gamma_rate + "0";
            }
        }

        for (int i=0; i < gamma_rate.length(); i++) {
            if (gamma_rate.substring(i, i+1).equals("1")) {
                epsilon_rate = epsilon_rate + "0";
            } else {
                epsilon_rate = epsilon_rate + "1";
            }
        }

        System.out.println(gamma_rate + " " + epsilon_rate);
        System.out.println("Gamma rate: " + Integer.parseInt(gamma_rate, 2));
        System.out.println("Epsilon rate: " + Integer.parseInt(epsilon_rate, 2));
        System.out.println("Power consumption: " + (Integer.parseInt(gamma_rate, 2) * Integer.parseInt(epsilon_rate, 2)));

    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);
        
        ArrayList<String> oxygenCodes = new ArrayList<>();
        ArrayList<String> co2Codes = new ArrayList<>();
        while(in.hasNextLine()) {
            String line = in.nextLine();
            oxygenCodes.add(line);
            co2Codes.add(line);
        }

        String oxygenCode = "";
        String co2Code = "";

        int n = oxygenCodes.get(0).length();
        for (int i=0; i < n; i++) {
            oxygenCode = oxygenCode + findMostSignificant(oxygenCodes, i);
            oxygenCodes = findMatches(oxygenCodes, oxygenCode);

            co2Code = co2Code + findLeastSignificant(co2Codes, i);
            co2Codes = findMatches(co2Codes, co2Code);

        }

        System.out.println("Oxygen: " + oxygenCode + ": " + Integer.parseInt(oxygenCode, 2));
        System.out.println("CO2: " + co2Code + ": " + Integer.parseInt(co2Code, 2));
        System.out.println("Result: " + (Integer.parseInt(oxygenCode, 2) * Integer.parseInt(co2Code, 2)));
    }

    static String findMostSignificant(ArrayList<String> A, int index) {
        if (A.size() == 1) {
            return A.get(0).substring(index, index+1);
            
        }
        
        int counter = 0;
        for (String line : A) {
            String bit = line.substring(index, index+1);
            if (bit.equals("1")) {
                counter++;
            } else {
                counter--;
            }
        }
        if (counter >= 0) {
            return "1";
        } else {
            return "0";
        }
    }

    static ArrayList<String> findMatches(ArrayList<String> A, String pattern) {
        ArrayList<String> B = new ArrayList<>();
        int patternLength = pattern.length();
        for (String s : A) {
            String sub = s.substring(0, patternLength);
            if (sub.equals(pattern)) {
                B.add(s);
            }
        }
        return B;
    }

    static String findLeastSignificant(ArrayList<String> A, int index) {
        if (A.size() == 1) {
            return A.get(0).substring(index, index+1);
            
        }
        
        int counter = 0;
        for (String line : A) {
            String bit = line.substring(index, index+1);
            if (bit.equals("1")) {
                counter++;
            } else {
                counter--;
            }
        }
        if (counter >= 0) {
            return "0";
        } else {
            return "1";
        }
    }
}