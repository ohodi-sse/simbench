public final class Main
{
    private static void main$3231c38a() {
        final String nextLine;
        if ((nextLine = new Scanner(System.in).nextLine()).charAt(0) == 'R' && nextLine.charAt(1) == 'R' && nextLine.charAt(2) == 'R') {
            System.out.println("3");
            return;
        }
        if ((nextLine.charAt(0) == 'R' && nextLine.charAt(1) == 'R') || (nextLine.charAt(1) == 'R' && nextLine.charAt(2) == 'R')) {
            System.out.println("2");
            return;
        }
        if (nextLine.charAt(0) == 'S' && nextLine.charAt(1) == 'S' && nextLine.charAt(2) == 'S') {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }
}