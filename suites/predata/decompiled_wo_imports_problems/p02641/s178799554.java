public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < nextInt2; ++i) {
            hashMap.put(scanner.nextInt(), 1);
        }
        int n = 0;
        int n2;
        while (true) {
            final int j = nextInt - n;
            n2 = nextInt + n;
            if (hashMap.get(j) == null) {
                n2 = j;
                break;
            }
            if (hashMap.get(n2) == null) {
                break;
            }
            ++n;
        }
        System.out.println(n2);
    }
}