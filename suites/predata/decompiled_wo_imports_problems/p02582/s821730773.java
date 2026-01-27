public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int i = 1;
        final String nextLine = scanner.nextLine();
        if (nextLine.charAt(0) == 'S' && nextLine.charAt(1) == 'S' && nextLine.charAt(2) == 'S') {
            System.out.print(0);
        }
        else {
            for (int j = 1; j < nextLine.length(); ++j) {
                if (nextLine.charAt(j) == 'R' && nextLine.charAt(j - 1) == 'R') {
                    ++i;
                }
            }
            System.out.print(i);
        }
    }
}