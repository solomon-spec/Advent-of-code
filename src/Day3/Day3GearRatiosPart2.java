package Day3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3GearRatiosPart2 {
    public static int row_m;
    public static int col_m;
    public static boolean isValid(int x, int y){
        return (0 <= x && x < row_m && 0 <= y && y <= col_m);
    }
    public static int[][] count ;
    public static int[][] gearRatio;
    public static void dfs(ArrayList<String> matrix, int[][] vals, int i, int j) {
        int num = vals[i][j]*100;
        int it = j;
        j -= 1;

        while(num > 0 && j < matrix.getFirst().length()){
            for (int x = i - 1;  x <= i+1; x++){

                if(isValid(x,j)){
                    char a = matrix.get(x).charAt(j);
                    if(a == '*'){
                       count[x][j]++;
                       gearRatio[x][j] *= vals[i][it];
                    }
                }
            }
            num /= 10;
            j++;
        }

    }
    public static void main(String[] args) {
        ArrayList<String> matrix = new ArrayList<>();



        try {
            File myfile = new File("C:\\Users\\solom\\IdeaProjects\\Advent-of-code\\src\\input.txt");
            Scanner in = new Scanner(myfile);
            while(in.hasNextLine()){
                matrix.add(in.nextLine());
                row_m++;
            }
            col_m = matrix.getFirst().length();
            int r = 0;

            int[][] vals = new int[matrix.size()][matrix.getFirst().length()];
            count = new int[matrix.size()][matrix.getFirst().length()];
            gearRatio = new int[matrix.size()][matrix.getFirst().length()];
            for(int i = 0; i < matrix.size(); i++){
                for(int j = 0; j < matrix.getFirst().length(); j++){

                    vals[i][j] = 0;
                    count[i][j] = 0;
                    gearRatio[i][j] = 1;
                }
            }

            for(String line: matrix){
                int c = 0;
                while (c < line.length()){
                    if(!Character.isDigit(line.charAt(c))){
                        c++;
                        continue;
                    }
                    int curNumber = 0;
                    int curC = c;
                    while (c < line.length() && Character.isDigit(line.charAt(c))){
                        curNumber = curNumber*10 + Character.getNumericValue(line.charAt(c));
                        c++;
                    }
                    vals[r][curC] = curNumber;
                    c++ ;
                }
                r++;
            }
            long ans = 0;
            for(int i = 0; i < matrix.size(); i++){
                for(int j = 0; j < matrix.getFirst().length(); j++){

                    if(vals[i][j] == 0)continue;
                    dfs(matrix,vals,i,j);
                }

            }

            for(int i = 0; i < matrix.size(); i++){
                for(int j = 0; j < matrix.getFirst().length(); j++) {

                    if(count[i][j] == 2) ans += gearRatio[i][j];

                }
            }
            System.out.println(ans);
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }

    }
}