import java.util.Scanner;





public class Main
{
    static Scanner sc;
    
    public static void main(final String[] array) {
        System.out.println(Main.sc.nextLong() * Math.round(Main.sc.nextDouble() * 100.0) / 100L);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}