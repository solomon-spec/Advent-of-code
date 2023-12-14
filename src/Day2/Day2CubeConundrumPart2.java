package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.lang.Math.max;

public class Day2CubeConundrumPart2 {
    public static void main(String[] args) {


        try {

            File myfile = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");
            Scanner in = new Scanner(myfile);
            Map<Character, Long> hm = new HashMap<>();

            hm.put('r', (long) 0);
            hm.put('g', (long) 0);
            hm.put('b', (long) 0);
            long totalValidGame = 0;

            while (in.hasNext()) {
                String cur = in.next();
                if (cur.equals("Game")) {

                    in.next();
                    totalValidGame += hm.get('r') * hm.get('g') * hm.get('b');
                    System.out.println(totalValidGame);
                    hm.put('r', (long) 0);
                    hm.put('g', (long) 0);
                    hm.put('b', (long) 0);
                    continue;
                }

                String sColor = in.next();
                char color = sColor.charAt(0);
                int x = Integer.parseInt(cur);
                hm.put(color, max(hm.get(color), x));


            }
            totalValidGame += hm.get('r') * hm.get('g') * hm.get('b');
            System.out.println(totalValidGame);

        } catch (FileNotFoundException e) {
            System.out.println(e);

        }
    }
}
