public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        Integer n;
        Integer n2;
        Integer n3;
        for (n = new Integer(scanner.next()), n2 = 0, n3 = 2; n >= n3; n3 *= 2, ++n2) {}
        System.out.println(n3 / 2);
        scanner.close();
    }
}