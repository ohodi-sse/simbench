public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final TreeSet set = new TreeSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        final int[] array2 = new int[102];
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            array2[iterator.next()] = 1;
        }
        int n = Integer.MAX_VALUE;
        int x = 0;
        for (int j = 0; j < array2.length; ++j) {
            if (array2[j] == 0 && n > Math.abs(nextInt - j)) {
                n = nextInt - j;
                x = j;
            }
        }
        System.out.println(x);
    }
}