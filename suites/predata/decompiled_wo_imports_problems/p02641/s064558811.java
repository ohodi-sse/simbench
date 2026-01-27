public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashMap hashMap = new HashMap();
        for (int i = 1; i <= nextInt2; ++i) {
            hashMap.put(scanner.nextInt(), 1);
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            int x;
            int n;
            for (x = nextInt, n = nextInt; hashMap.containsKey(x) && hashMap.containsKey(n); --x, ++n) {}
            if (!hashMap.containsKey(x)) {
                System.out.println(x);
            }
            else {
                System.out.println(n);
            }
        }
    }
}