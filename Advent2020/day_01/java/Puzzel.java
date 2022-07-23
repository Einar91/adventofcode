import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Puzzel {
    public static void main(String[] args) throws FileNotFoundException
    {
        File inputFile = new File("input.txt");
        Scanner in = new Scanner(inputFile);

        ArrayList<Double> all_numbers = new ArrayList<Double>();
        
        while (in.hasNextDouble()){
            double value_one = in.nextDouble();
            all_numbers.add(value_one);
        }

        for (int i = 0; i < all_numbers.size(); i++){
            double number_to_check = all_numbers.get(i);
            for (int j = 0; j < all_numbers.size(); j++){
                double num_add = all_numbers.get(j);
                if (number_to_check + num_add == 2020){
                    System.out.println(number_to_check);
                    System.out.println(num_add);
                    System.out.println(number_to_check * num_add);
                }
            }
            
        }
    }
}