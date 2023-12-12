package Day1;
import static java.lang.Character.isDigit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day1Trebuchet {
    public static int calc(String word,int x){
        int start = (x > 0) ? 0: word.length()-1;
        for(int i = start; i < word.length(); i += x){
            if(isDigit(word.charAt(i))){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        long tot = 0;
        
        try {

            File myFile = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");
            Scanner in = new Scanner(myFile);
            while(in.hasNextLine()){
                String input = in.next();
                StringBuilder current = new StringBuilder();
                current.append(input.charAt(calc(input, 1)));
                current.append(input.charAt(calc(input, -1)));

                tot += Integer.parseInt(current.toString());
            }
            System.out.println(tot);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }


}
