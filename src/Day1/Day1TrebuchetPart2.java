package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Character.isDigit;
public class Day1TrebuchetPart2 {
    public static int calc(String word){

        int[] ans = {word.length(),-1};
        String[] stringNumbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine","1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int val[] = {0,0};

        int cur = 1;
        for(String num : stringNumbers ){
            int index = word.indexOf(num);
            int left  = (index != -1) ? index: word.length();

            index = word.lastIndexOf(num);
            int right = index;

            if(left < ans[0]){
                ans[0] = left;
                val[0] = cur % 10 + cur/10;
            }
            if(right > ans[1]){
                ans[1] = right;
                System.out.println(cur);
                val[1] = cur % 10 + cur/10;
            }
            cur++;
        }

        //System.out.println(val[0]+ " " + val[1]);
        return val[0]*10 + val[1];
    }

    public static void main(String[] args){
        long tot = 0;

        try {
            File myFile = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");
            Scanner in = new Scanner(myFile);

            while(in.hasNextLine()){
                String input = in.next();
                tot += calc(input);

            }

            System.out.println(tot);
        }

        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
