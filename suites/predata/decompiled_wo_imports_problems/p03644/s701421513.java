public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final StringBuilder sb = new StringBuilder();
        int nextInt;
        int i;
        for (nextInt = scanner.nextInt(), i = 2; i <= nextInt; i *= 2) {}
        System.out.println(i / 2);
    }
}