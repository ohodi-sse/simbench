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
            case "SSR": {
                System.out.println("1");
                break;
            }
            case "SRR": {
                System.out.println("2");
                break;
            }
            case "RRR": {
                System.out.println("3");
                break;
            }
            case "RRS": {
                System.out.println("2");
                break;
            }
            case "RSS": {
                System.out.println("1");
                break;
            }
            case "RSR": {
                System.out.println("1");
                break;
            }
            case "SRS": {
                System.out.println("1");
                break;
            }
        }
    }
}