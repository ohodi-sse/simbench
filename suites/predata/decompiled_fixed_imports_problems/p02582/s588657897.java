import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        String x = "0";
        if (nextLine.indexOf("RRR") > -1) {
            x = "3";
        }
        else if (nextLine.indexOf("RR") > -1) {
            x = "2";
        }
        else if (nextLine.indexOf("R") > -1) {
            x = "1";
        }
        System.out.println(x);
    }
}