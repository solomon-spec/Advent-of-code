package Day5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day5YouGiveASeedAFertilizer {
    public static void main(String[] args) {
        try{
            File myFile  = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");
            Scanner in = new Scanner(myFile);

            ArrayList<Long> arr = new ArrayList<Long>();
            in.next();

            while (in.hasNextLong()){
                arr.add(in.nextLong());
            }

            while (in.hasNextLine()) {

                 String curInput = in.nextLine();
                 ArrayList<Long> arr2 = new ArrayList<Long>();

                 while(!curInput.isBlank()){

                     String[] numbersArray = curInput.split(" ");

                     long cur = Long.parseLong(numbersArray[0]);
                     long prev = Long.parseLong(numbersArray[1]);
                     long range = Long.parseLong(numbersArray[2]);

                     Iterator<Long> iterator = arr.iterator();

                     while(iterator.hasNext()){
                        Long elem = iterator.next();

                        if(elem >= prev && elem <= prev + range){
                            iterator.remove();
                            arr2.add(elem - (prev- cur));
                        }
                     }
                     if(in.hasNextLine()){
                         curInput = in.nextLine();
                     }
                     else{
                         curInput = "";
                     }

                }

                arr.addAll(arr2);
                if(in.hasNextLine()){
                    in.nextLine();
                }

            }

            long minimum = Collections.min(arr);
            System.out.println("min: " + minimum);
        }

        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }

    }
}
