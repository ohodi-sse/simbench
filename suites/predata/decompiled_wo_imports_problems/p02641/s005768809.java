public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list = new ArrayList();
        int i = 0;
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        final String[] split = list.get(0).split(" ", 0);
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        final int[] a = new int[int2];
        if (int2 != 0) {
            final String[] split2 = list.get(1).split(" ", 0);
            while (i < int2) {
                a[i] = Integer.parseInt(split2[i]);
                ++i;
            }
            Arrays.sort(a);
            check(a, int1, int2);
        }
        else {
            System.out.println(int1);
        }
        scanner.close();
    }
    
    public static void check(final int[] array, final int n, final int n2) {
        final ArrayList list = new ArrayList(array.length);
        for (int i = 0; i < array.length; ++i) {
            list.add(array[i]);
        }
        int n3 = n;
        int n4 = n;
        while (list.contains(n3)) {
            --n3;
            if (!list.contains(n4)) {
                System.out.println(n4);
                return;
            }
            ++n4;
        }
        System.out.println(n3);
    }
}