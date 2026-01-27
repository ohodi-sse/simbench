public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final Integer n = new Integer(Integer.parseInt(scanner.next()));
        final int int1 = Integer.parseInt(scanner.next());
        if (int1 == 0) {
            System.out.println(n);
            return;
        }
        final Integer[] a = new Integer[int1];
        for (int i = 0; i < int1; ++i) {
            a[i] = new Integer(Integer.parseInt(scanner.next()));
        }
        if (!Arrays.asList(a).contains(n)) {
            System.out.println(n);
            return;
        }
        Arrays.sort(a);
        Arrays.asList(a).indexOf(n);
        int j = n;
        int n2 = 0;
        while (j <= a[a.length - 1]) {
            ++n2;
            j = n - n2;
            if (!Arrays.asList(a).contains(new Integer(j))) {
                break;
            }
        }
        int intValue = n;
        int n3 = 0;
        while (a[0] <= intValue) {
            ++n3;
            intValue = n + n3;
            if (!Arrays.asList(a).contains(new Integer(intValue))) {
                break;
            }
        }
        if (n2 <= n3) {
            System.out.println(n - n2);
        }
        else {
            System.out.println(n + n3);
        }
    }
}