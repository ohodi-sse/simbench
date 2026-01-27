public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'S') {
            System.out.println(2);
        }
        else if (next.charAt(1) == 'R' && next.charAt(2) == 'R' && next.charAt(0) == 'S') {
            System.out.println(2);
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'S' && next.charAt(2) == 'R') {
            System.out.println(1);
        }
        else if (next.charAt(0) == 'S' && next.charAt(1) == 'S' && next.charAt(2) == 'R') {
            System.out.println(1);
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'S' && next.charAt(2) == 'S') {
            System.out.println(1);
        }
        else if (next.charAt(0) == 'S' && next.charAt(1) == 'R' && next.charAt(2) == 'S') {
            System.out.println(1);
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            System.out.println(3);
        }
        else if (next.charAt(0) == 'S' && next.charAt(1) == 'S' && next.charAt(2) == 'S') {
            System.out.println(0);
        }
    }
}