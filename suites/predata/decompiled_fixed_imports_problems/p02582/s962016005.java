import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        next.length();
        if (next.charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            System.out.print(3);
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'S') {
            System.out.print(2);
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'S' && next.charAt(2) == 'R') {
            System.out.print(1);
        }
        else if (next.charAt(0) == 'S' && next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            System.out.print(2);
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'S' && next.charAt(2) == 'S') {
            System.out.print(1);
        }
        else if (next.charAt(0) == 'S' && next.charAt(1) == 'R' && next.charAt(2) == 'S') {
            System.out.print(1);
        }
        else if (next.charAt(0) == 'S' && next.charAt(1) == 'S' && next.charAt(2) == 'R') {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }
    }
}