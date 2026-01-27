public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        int i = 2;
        if (int1 == 1) {
            System.out.println(1);
        }
        else {
            while (i <= int1) {
                i *= 2;
            }
            System.out.println(i / 2);
        }
        scanner.close();
    }
}