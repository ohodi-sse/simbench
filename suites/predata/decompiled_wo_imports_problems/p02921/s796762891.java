public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final String[] split = nextLine.split("");
        final String[] split2 = nextLine2.split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].compareTo(split2[i]) == 0) {
                ++x;
            }
        }
        System.out.println(x);
    }
}