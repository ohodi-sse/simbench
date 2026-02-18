public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int int1 = 0;
        int n = 100;
        final ArrayList list = new ArrayList();
        for (int i = -100; i <= 101; ++i) {
            list.add(String.valueOf(i));
        }
        for (int j = 1; j <= nextInt2; ++j) {
            final String next = scanner.next();
            if (list.contains(next)) {
                list.remove(next);
            }
        }
        for (int k = 0; k < list.size(); ++k) {
            final int abs;
            if ((abs = Math.abs(nextInt - Integer.parseInt(list.get(k)))) < n) {
                n = abs;
                int1 = Integer.parseInt((String)list.get(k));
            }
        }
        System.out.println(int1);
        scanner.close();
    }
}