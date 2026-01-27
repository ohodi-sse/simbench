public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String[] array2 = new String[3];
        int x = 0;
        scanner.useDelimiter("");
        array2[0] = scanner.next();
        array2[1] = scanner.next();
        array2[2] = scanner.next();
        scanner.next();
        for (int i = 0; i < 3; ++i) {
            if (array2[i].equals(scanner.next())) {
                ++x;
            }
        }
        System.out.println(x);
    }
}