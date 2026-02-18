public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int x = 0;
        if (nextInt2 == 0) {
            x = nextInt;
        }
        else {
            final ArrayList list = new ArrayList();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(scanner.nextInt());
            }
            final HashMap hashMap = new HashMap();
            for (int j = 0; j <= 105; ++j) {
                hashMap.put(j, Math.abs(nextInt - j));
            }
            int n = Integer.MAX_VALUE;
            for (final int intValue : hashMap.keySet()) {
                final int intValue2;
                if ((intValue2 = (int)hashMap.get(intValue)) < n && !list.contains(intValue)) {
                    x = intValue;
                    n = intValue2;
                }
            }
        }
        scanner.close();
        System.out.println(x);
    }
}