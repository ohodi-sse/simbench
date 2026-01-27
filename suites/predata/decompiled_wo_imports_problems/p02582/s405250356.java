public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        if (nextLine.charAt(0) == 'R' && nextLine.charAt(1) == 'R' && nextLine.charAt(2) == 'R') {
            System.out.println("3");
        }
        else if ((nextLine.charAt(0) == 'R' && nextLine.charAt(1) == 'R') || (nextLine.charAt(1) == 'R' && nextLine.charAt(2) == 'R')) {
            System.out.println("2");
        }
        else if (nextLine.charAt(0) == 'S' && nextLine.charAt(1) == 'S' && nextLine.charAt(2) == 'S') {
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }
    }
}