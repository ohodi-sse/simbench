import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        switch (nextLine) {
            case "SSS": {
                System.out.println("0");
                break;
            }
            case "SSR":
            case "SRS":
            case "RSS":
            case "RSR": {
                System.out.println("1");
                break;
            }
            case "SRR":
            case "RRS": {
                System.out.println("2");
                break;
            }
            case "RRR": {
                System.out.println("3");
                break;
            }
        }
    }
}