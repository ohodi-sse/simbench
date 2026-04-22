import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final String substring = next.substring(0, 1);
        final String substring2 = next.substring(1, 2);
        final String substring3 = next.substring(2, 3);
        if (substring.equals("R") && substring2.equals("R") && substring3.equals("R")) {
            System.out.println("3");
        }
        else if (substring.equals("R") && substring2.equals("R") && substring3.equals("S")) {
            System.out.println("2");
        }
        else if (substring.equals("S") && substring2.equals("R") && substring3.equals("R")) {
            System.out.println("2");
        }
        else if (substring.equals("R") && substring2.equals("S") && substring3.equals("S")) {
            System.out.println("1");
        }
        else if (substring.equals("S") && substring2.equals("R") && substring3.equals("S")) {
            System.out.println("1");
        }
        else if (substring.equals("S") && substring2.equals("S") && substring3.equals("R")) {
            System.out.println("1");
        }
        else if (substring.equals("R") && substring2.equals("S") && substring3.equals("R")) {
            System.out.println("1");
        }
        else if (substring.equals("S") && substring2.equals("S") && substring3.equals("S")) {
            System.out.println("0");
        }
    }
}