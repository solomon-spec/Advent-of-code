package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Day4ScratchcardsPart2 {
    public static void main(String[] args) {
        try{
            File myfile = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");

            Scanner in = new Scanner(myfile);
            long total = 0;

            int[] copy = new int[205];

            for(int i = 0; i < 205; i++){
                copy[i] = 1;
            }
            int ind = 0;
            while(in.hasNextLine()){
                int curTot = 0;
                in.next();
                in.next();

                Set<Integer> winningNumbers = new HashSet<Integer>();
                for(int i = 0; i < 10; i++){
                    winningNumbers.add(in.nextInt());
                }

                in.next();
                for(int i = 0; i < 25; i++){
                    int myNumber = in.nextInt();
                    if(winningNumbers.contains(myNumber)){
                        curTot++;
                    }
                }

                for(int i = ind+1; i < 205 && i <= ind + curTot; i++){
                    copy[i] += copy[ind];
                }
                ind++;

            }
            for (int i = 0; i < 203; i++) {
                total += copy[i];
            }


            System.out.println(total);

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}