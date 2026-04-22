import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        System.out.println(weatherReport(new Scanner(System.in).next()));
    }
    
    public static int weatherReport(final String s) {
        if (s.matches("R{3}")) {
            return 3;
        }
        if (s.matches(".*R{2}.*")) {
            return 2;
        }
        if (s.matches(".*R.*")) {
            return 1;
        }
        return 0;
    }
}