public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = nextInt - 1;
        int n2 = nextInt + 1;
        if (set.isEmpty() || !set.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        while (set.contains(n)) {
            --n;
            if (!set.contains(n2)) {
                System.out.println(n2);
                return;
            }
            ++n2;
        }
        System.out.println(n);
    }
}