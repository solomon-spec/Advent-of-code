package Day2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Day2CubeConundrum {

    public static void main(String[] args) {
        Map<Character,Integer> hm = new HashMap<>();
        hm.put('r',12);
        hm.put('g',13);
        hm.put('b',14);


        try {
            File myfile = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");
            Scanner in = new Scanner(myfile);
            int game = 0;
            long totalValidGame = 0;
            boolean valid = true;
            while(in.hasNext()){
                String cur = in.next();
                if(cur.equals("Game")){
                    if(valid){
                        totalValidGame += game;
                    }
                    valid = true;
                    in.next();
                    game++;
                    continue;
                }
                String sColor = in.next();
                char color = sColor.charAt(0);
                int x = Integer.parseInt(cur);
                if(Integer.parseInt(cur) > hm.get(color))valid = false;





            }
            if(valid)totalValidGame += game;
            System.out.println(totalValidGame);
        }
        catch (FileNotFoundException e){
            System.out.println(e);

        }
    }
}
