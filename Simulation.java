import java.util.Arrays;
import java.util.Scanner;

public class Simulation{
    public static void main(String[] args) {
        printPlinko();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter number of balls");
        long balls = sc.nextLong();
        sc.close();
        run(balls, rows);
    }
    public static void run(long balls, int rows){
        long[] loc1 = new long[rows+1];
        long[] loc2 = new long[rows+1];
        int log = log10(balls);
        loc1[0] = balls;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j <= i; j++){
                long count = loc1[j];
                int l = 0;
                for(int k = 0; k < count; k++){
                    if(Math.random() >= 0.5) l++;
                }
                loc2[j] += l;
                loc2[j+1] += count - l;
            }
            loc1 = loc2.clone();
            loc2 = new long[rows+1];
            printSpaces(rows/2 *  log - (i * log / 3));
            System.out.println(Arrays.toString(Arrays.copyOf(loc1, i+2)));
        }
    }
    public static void printSpaces(int numSpaces) {
        System.out.print(" ".repeat(numSpaces));
    }
    public static int log10(long balls){
        int size = 0;
        while(balls > 0){
            size++;
            balls/=10;
        }
        return size;
    }
    static void printPlinko(){
        System.out.println("  _____  _      _____ _   _ _  ______  \n" + //
                        " |  __ \\| |    |_   _| \\ | | |/ / __ \\ \n" + //
                        " | |__) | |      | | |  \\| | ' / |  | |\n" + //
                        " |  ___/| |      | | | . ` |  <| |  | |\n" + //
                        " | |    | |____ _| |_| |\\  | . \\ |__| |\n" + //
                        " |_|    |______|_____|_| \\_|_|\\_\\____/ \n" + //
                        "                                       \n" + //
                        "                                       ");
    }
    
}