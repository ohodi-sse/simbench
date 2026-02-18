final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashMap hashMap = new HashMap();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
            hashMap.put(array[i], 1);
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        PrintStream printStream = null;
        int x = 0;
        Label_0325: {
            if (nextInt2 == 0) {
                printStream = System.out;
            }
            else {
                printStream = System.out;
                final int n = nextInt;
                final HashMap hashMap2 = hashMap;
                final int n2 = min;
                final int n3 = max;
                final int n4 = n2;
                final HashMap hashMap3 = hashMap2;
                final int n5;
                if ((n5 = n) < n4) {
                    x = ((n5 - 1 <= n4) ? (n5 - 1) : (n5 + 1));
                    break Label_0325;
                }
                if (n5 > n3) {
                    x = ((n5 - 1 > n3) ? (n5 - 1) : (n5 + 1));
                    break Label_0325;
                }
                final ArrayList<Comparable> list = new ArrayList<Comparable>();
                for (int j = n4; j <= n3; ++j) {
                    if (!hashMap3.containsKey(j)) {
                        list.add(j);
                    }
                }
                if (list.size() == 0) {
                    x = ((Math.abs(n4 - 1 - n5) > Math.abs(n3 + 1 - n5)) ? (n3 + 1) : (n4 - 1));
                    break Label_0325;
                }
                int n6 = Integer.MAX_VALUE;
                nextInt = 0;
                Collections.sort(list);
                while (list.size() != 0) {
                    final int intValue = list.get(0);
                    final int abs;
                    if ((abs = Math.abs(n5 - intValue)) < n6) {
                        n6 = abs;
                        nextInt = intValue;
                    }
                    list.remove(0);
                }
            }
            x = nextInt;
        }
        printStream.println(x);
    }
    
    private static int some$51defbd(final int n, final HashMap<Integer, Integer> hashMap, int intValue, int abs) {
        if (n < intValue) {
            if (n - 1 <= intValue) {
                return n - 1;
            }
            return n + 1;
        }
        else if (n > abs) {
            if (n - 1 > abs) {
                return n - 1;
            }
            return n + 1;
        }
        else {
            final ArrayList list = new ArrayList();
            for (int i = intValue; i <= abs; ++i) {
                if (!hashMap.containsKey(i)) {
                    list.add(i);
                }
            }
            if (list.size() != 0) {
                int n2 = Integer.MAX_VALUE;
                int n3 = 0;
                Collections.sort((List<Comparable>)list);
                while (list.size() != 0) {
                    intValue = (int)list.get(0);
                    if ((abs = Math.abs(n - intValue)) < n2) {
                        n2 = abs;
                        n3 = intValue;
                    }
                    list.remove(0);
                }
                return n3;
            }
            if (Math.abs(intValue - 1 - n) > Math.abs(abs + 1 - n)) {
                return abs + 1;
            }
            return intValue - 1;
        }
    }
}