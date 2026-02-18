public final class Main
{
    private static MyScanner scan;
    private static PrintWriter out;
    
    private static void main$3231c38a() {
        Main.scan = new MyScanner();
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = 1;
    Label_0032:
        while (n-- > 0) {
            int int1 = Integer.parseInt(Main.scan.next());
            final int int2 = Integer.parseInt(Main.scan.next());
            final ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < int2; ++i) {
                list.add(Integer.parseInt(Main.scan.next()));
            }
            int n2 = int1;
            while (list.contains(n2)) {
                --n2;
                if (!list.contains(int1)) {
                    Main.out.println(int1);
                    continue Label_0032;
                }
                ++int1;
            }
            Main.out.println(n2);
        }
        Main.out.close();
    }
    
    private static int gcd(int n, int i) {
        while (i != 0) {
            if (n == 0) {
                return i;
            }
            if (n > i) {
                n %= i;
            }
            else {
                final int n2 = n;
                i %= n;
                n = n2;
            }
        }
        return n;
    }
    
    private static int lcm(int n, int i) {
        final int n2 = n * i;
        final int n3 = n;
        i = i;
        n = n3;
        while (i != 0) {
            if (n == 0) {
                final int n4 = i;
                return n2 / n4;
            }
            if (n > i) {
                n %= i;
            }
            else {
                final int n5 = n;
                i %= n;
                n = n5;
            }
        }
        final int n4 = n;
        return n2 / n4;
    }
    
    private static int min(final int n, final int n2) {
        if (n <= n2) {
            return n;
        }
        return n2;
    }
    
    private static int max(final int n, final int n2) {
        if (n >= n2) {
            return n;
        }
        return n2;
    }
    
    private static int abs(final int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }
    
    private static ArrayList<Integer> getPrimes(final int n) {
        final boolean[] array;
        Arrays.fill(array = new boolean[n + 1], true);
        int n2 = 2;
        while (true) {
            final int n3 = n2;
            if (n3 * n3 > n) {
                break;
            }
            if (array[n2]) {
                for (int i = n2 << 1; i <= n; i += n2) {
                    array[i] = false;
                }
            }
            ++n2;
        }
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 2; j <= n; ++j) {
            if (array[j]) {
                list.add(j);
            }
        }
        return list;
    }
    
    private static boolean isPrime(final int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int n2 = 2; n2 < Math.sqrt(n) + 1.0; ++n2) {
            if (n % n2 == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static ArrayList<Integer> getDivisors(final int n) {
        final ArrayList list = new ArrayList();
        int i = 1;
        while (true) {
            final int n2 = i;
            if (n2 * n2 > n) {
                break;
            }
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
            ++i;
        }
        return list;
    }
    
    private static int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(Main.scan.next());
        }
        return array;
    }
    
    private static Integer[] nextIntegerArray(final int n) {
        final Integer[] array = new Integer[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(Main.scan.next());
        }
        return array;
    }
    
    private static int[][] nextIntMatrix(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Integer.parseInt(Main.scan.next());
            }
        }
        return array;
    }
    
    private static Integer[][] nextIntegerMatrix(final int n, final int n2) {
        final Integer[][] array = new Integer[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Integer.parseInt(Main.scan.next());
            }
        }
        return array;
    }
    
    private static void printIntArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            Main.out.print("" + array[i]);
        }
        Main.out.println();
    }
    
    private static void printIntegerArray(final Integer[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            Main.out.print("" + (int)array[i]);
        }
        Main.out.println();
    }
    
    private static void printIntMatrix(final int[][] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            int[] array2;
            for (int length2 = (array2 = array[i]).length, j = 0; j < length2; ++j) {
                Main.out.print("" + array2[j]);
            }
            Main.out.println();
        }
    }
    
    private static void printIntegerMatrix(final Integer[][] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            Integer[] array2;
            for (int length2 = (array2 = array[i]).length, j = 0; j < length2; ++j) {
                Main.out.print("" + array2[j]);
            }
            Main.out.println();
        }
    }
    
    private static void help(final int n, final int n2) {
        Main.out.println("Test Case: " + (n + 1) + " | Variable Output: " + n2);
    }
    
    private static void help(final int n, final String s) {
        Main.out.println("Test Case: " + (n + 1) + " | Variable Output: " + s);
    }
    
    private static void help(final int n, final char[] array) {
        Main.out.print("Test Case: " + (n + 1) + " | Variable Output: ");
        for (int length = array.length, i = 0; i < length; ++i) {
            Main.out.print("" + array[i]);
        }
        Main.out.println();
    }
    
    static final class Node implements Comparable<Node>
    {
        private int x;
        private int y;
        
        private Node(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        private int compareTo(final Node node) {
            if (this.x == node.x) {
                return 0;
            }
            if (this.x > node.x) {
                return 1;
            }
            return -1;
        }
        
        private boolean equals(final Node node) {
            return this.x == node.x;
        }
    }
    
    static final class Edge implements Comparable<Edge>
    {
        private Node a;
        private Node b;
        private int weight;
        
        private Edge(final Node a, final Node b, final int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        
        private int compareTo(final Edge edge) {
            if (this.weight == edge.weight) {
                return 0;
            }
            if (this.weight > edge.weight) {
                return 1;
            }
            return -1;
        }
    }
    
    public static final class MyScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public MyScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}