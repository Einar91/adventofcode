import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //partOne();
        partTwo();

    }

    static void partOne() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        HashMap<String, Integer> coordinates = new HashMap<>();

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" -> ");
            ArrayList<String> numberRange = generateRangeHV(line[0], line[1]);
            for (String d : numberRange) {
                if (!coordinates.containsKey(d)) {
                    coordinates.put(d, 0);
                }
                System.out.println("" + d);
                coordinates.put(d, coordinates.get(d)+1);
            }
        }

        int overlappingLines = 0;
        for (int v : coordinates.values()) {
            if (v > 1) {
                overlappingLines++;
            }
        }
        System.out.println("Number of overlapping lines: " + overlappingLines);
    }

    static void partTwo() throws IOException {
        String filnavn = "input.txt";
        File fil = new File(filnavn);
        Scanner in = new Scanner(fil);

        HashMap<String, Integer> coordinates = new HashMap<>();

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" -> ");
            ArrayList<String> numberRange = generateRangeAll(line[0], line[1]);
            for (String d : numberRange) {
                if (!coordinates.containsKey(d)) {
                    coordinates.put(d, 0);
                }
                System.out.println("" + d);
                coordinates.put(d, coordinates.get(d)+1);
            }
        }

        int overlappingLines = 0;
        for (int v : coordinates.values()) {
            if (v > 1) {
                overlappingLines++;
            }
        }
        System.out.println("Number of overlapping lines: " + overlappingLines);
        

    }

    static ArrayList<String> generateRangeHV(String coordinateOne, String coordinateTwo) {
        ArrayList<String> rangeOfCoords = new ArrayList<>();
        
        int x1 = Integer.parseInt(coordinateOne.split(",")[0]);
        int y1 = Integer.parseInt(coordinateOne.split(",")[1]);
        int x2 = Integer.parseInt(coordinateTwo.split(",")[0]);
        int y2 = Integer.parseInt(coordinateTwo.split(",")[1]);

        if (x1 == x2) {
            if (y1 < y2) {
                while (y1 <= y2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    y1++;
                }
            }
            else if (y1 > y2) {
                while (y1 >= y2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    y1--;
                }
            }
            else if (y1 == y2) {
                String num = x1 + "." + y1;
                rangeOfCoords.add(num);
            }
        }
        else if (y1 == y2) {
            if (x1 < x2) {
                while (x1 <= x2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    x1++;
                }
            }
            else if (x1 > x2) {
                while (x1 >= x2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    x1--;
                }
            }
        }
        return rangeOfCoords;
    }

    static ArrayList<String> generateRangeAll(String coordinateOne, String coordinateTwo) {
        ArrayList<String> rangeOfCoords = new ArrayList<>();
        
        int x1 = Integer.parseInt(coordinateOne.split(",")[0]);
        int y1 = Integer.parseInt(coordinateOne.split(",")[1]);
        int x2 = Integer.parseInt(coordinateTwo.split(",")[0]);
        int y2 = Integer.parseInt(coordinateTwo.split(",")[1]);

        if(Math.abs(x1-x2) == Math.abs(y1-y2)) {
           int x1_d = x1;
           int y1_d = y1;
           int x2_d = x2;
           int y2_d = y2;


            if (x1 < x2 && y1 < y2) {
                while ( x1_d <= x2) {
                    String num = x1_d + "." + y1_d;
                    rangeOfCoords.add(num);
                    x1_d++; y1_d++;
                }
            }
            else if (x1 > x2 && y1 > y2) {
                while ( x1_d >= x2) {
                    String num = x1_d + "." + y1_d;
                    rangeOfCoords.add(num);
                    x1_d--; y1_d--;
                }
            }
            else if (x1 < x2 && y1 > y2) {
                while ( x1_d <= x2) {
                    String num = x1_d + "." + y1_d;
                    rangeOfCoords.add(num);
                    x1_d++; y1_d--;
                }
            }
            else if (x1 > x2 && y1 < y2) {
                while ( x1_d >= x2) {
                    String num = x1_d + "." + y1_d;
                    rangeOfCoords.add(num);
                    x1_d--; y1_d++;
                }
            }
           
        }
        else if (x1 == x2) {
            if (y1 < y2) {
                while (y1 <= y2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    y1++;
                }
            }
            else if (y1 > y2) {
                while (y1 >= y2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    y1--;
                }
            }
            else if (y1 == y2) {
                String num = x1 + "." + y1;
                rangeOfCoords.add(num);
            }
        }
        else if (y1 == y2) {
            if (x1 < x2) {
                while (x1 <= x2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    x1++;
                }
            }
            else if (x1 > x2) {
                while (x1 >= x2) {
                    String num = x1 + "." + y1;
                    rangeOfCoords.add(num);
                    x1--;
                }
            }
        }
        return rangeOfCoords;
    }

}