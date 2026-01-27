public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int max = 0;
        int b = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'S') {
                b = 0;
            }
            else {
                ++b;
                max = Math.max(max, b);
            }
        }
        System.out.println(max);
        scanner.close();
    }
}