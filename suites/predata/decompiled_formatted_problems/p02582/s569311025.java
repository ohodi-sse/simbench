import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        final String s = next;
        switch (s) {
            case "RSS":
            case "SRS":
            case "SSR":
            case "RSR": {
                x = 1;
                break;
            }
            case "RRS":
            case "SRR": {
                x = 2;
                break;
            }
            case "RRR": {
                x = 3;
                break;
            }
        }
        System.out.println(x);
    }
}