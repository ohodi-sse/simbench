public class Main
{
    static long mod;
    public static String alpha;
    
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        long n = 1L;
        while (n-- > 0L) {
            final int[] array2 = new int[1000];
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            final ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(scanner.nextInt());
                final int[] array3 = array2;
                final int abs = Math.abs(nextInt - list.get(i));
                ++array3[abs];
            }
            int n2 = 0;
            int x = 0;
            if (array2[0] != 1) {
                System.out.println(nextInt);
            }
            else {
                for (int j = 1; j < array2.length; ++j) {
                    if (array2[j] < 2) {
                        n2 = nextInt - j;
                        x = nextInt + j;
                        break;
                    }
                }
                if (list.indexOf(n2) > -1) {
                    System.out.println(x);
                }
                else {
                    System.out.println(n2);
                }
            }
        }
        scanner.close();
    }
    
    static ArrayList factors(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 1; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) {
                if (i == Math.sqrt(n)) {
                    list.add(i);
                }
                else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        Collections.sort((List<Comparable>)list);
        return list;
    }
    
    static boolean isPrime(final int n) {
        return factors(n).size() == 2;
    }
    
    static long GCD(final long n, final long n2) {
        if (n == 0L) {
            return n2;
        }
        if (n2 == 0L) {
            return n;
        }
        if (n == n2) {
            return n;
        }
        if (n > n2) {
            return GCD(n - n2, n2);
        }
        return GCD(n, n2 - n);
    }
    
    static long LCM(final long n, final long n2) {
        return n * n2 / GCD(n, n2);
    }
    
    static String rev(final String s) {
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < (s.length() + 1) / 2; ++i) {
            final char c = charArray[i];
            charArray[i] = charArray[s.length() - i - 1];
            charArray[s.length() - i - 1] = c;
        }
        return new String(charArray);
    }
    
    static long pow(final long n, final long n2) {
        if (n2 == 0L) {
            return 1L;
        }
        if (n2 == 1L) {
            return n;
        }
        final long pow = pow(n, n2 / 2L);
        if (n2 % 2L == 0L) {
            return pow * pow;
        }
        return pow * pow * n;
    }
    
    static long powMod(final long n, final long n2) {
        if (n2 == 0L) {
            return 1L;
        }
        if (n2 == 1L) {
            return n % Main.mod;
        }
        final long n3 = powMod(n, n2 / 2L) % Main.mod;
        long n4 = n3 * n3 % Main.mod;
        if (n2 % 2L == 1L) {
            n4 = n4 * n % Main.mod;
        }
        return n4 % Main.mod;
    }
    
    static {
        Main.mod = (long)(Math.pow(10.0, 9.0) + 7.0);
        Main.alpha = "zabcdefghijklmnopqrstuvwxy";
    }
}