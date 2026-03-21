import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;





public class Main
{
    public static MyScanner scan;
    public static PrintWriter out;
    
    public static void main(final String[] array) {
        Main.scan = new MyScanner();
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = 1;
    Label_0032:
        while (n-- > 0) {
            final int nextInt = Main.scan.nextInt();
            final int nextInt2 = Main.scan.nextInt();
            final ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(Main.scan.nextInt());
            }
            int n2 = nextInt;
            int n3 = nextInt;
            while (true) {
                while (list.contains(n2)) {
                    --n2;
                    if (!list.contains(n3)) {
                        Main.out.println(n3);
                        continue Label_0032;
                    }
                    ++n3;
                }
                Main.out.println(n2);
                continue;
            }
        }
        Main.out.close();
    }
    
    public static int gcd(final int n, final int n2) {
        if (n2 == 0) {
            return n;
        }
        if (n == 0) {
            return n2;
        }
        return (n > n2) ? gcd(n % n2, n2) : gcd(n, n2 % n);
    }
    
    public static int lcm(final int n, final int n2) {
        return n * n2 / gcd(n, n2);
    }
    
    public static int min(final int n, final int n2) {
        if (n <= n2) {
            return n;
        }
        return n2;
    }
    
    public static int max(final int n, final int n2) {
        if (n >= n2) {
            return n;
        }
        return n2;
    }
    
    public static int abs(final int n) {
        if (n < 0) {
            return n * -1;
        }
        return n;
    }
    
    public static ArrayList<Integer> getPrimes(final int n) {
        final boolean[] a = new boolean[n + 1];
        Arrays.fill(a, true);
        for (int n2 = 2; n2 * n2 <= n; ++n2) {
            if (a[n2]) {
                for (int i = n2 * 2; i <= n; i += n2) {
                    a[i] = false;
                }
            }
        }
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 2; j <= n; ++j) {
            if (a[j]) {
                list.add(j);
            }
        }
        return list;
    }
    
    public static boolean isPrime(final int n) {
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
    
    public static ArrayList<Integer> getDivisors(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }
    
    public static int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.scan.nextInt();
        }
        return array;
    }
    
    public static Integer[] nextIntegerArray(final int n) {
        final Integer[] array = new Integer[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.scan.nextInt();
        }
        return array;
    }
    
    public static int[][] nextIntMatrix(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Main.scan.nextInt();
            }
        }
        return array;
    }
    
    public static Integer[][] nextIntegerMatrix(final int n, final int n2) {
        final Integer[][] array = new Integer[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Main.scan.nextInt();
            }
        }
        return array;
    }
    
    public static void printIntArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            Main.out.print("" + array[i]);
        }
        Main.out.println();
    }
    
    public static void printIntegerArray(final Integer[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            Main.out.print("" + (int)array[i]);
        }
        Main.out.println();
    }
    
    public static void printIntMatrix(final int[][] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final int[] array2 = array[i];
            for (int length2 = array2.length, j = 0; j < length2; ++j) {
                Main.out.print("" + array2[j]);
            }
            Main.out.println();
        }
    }
    
    public static void printIntegerMatrix(final Integer[][] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Integer[] array2 = array[i];
            for (int length2 = array2.length, j = 0; j < length2; ++j) {
                Main.out.print("" + array2[j]);
            }
            Main.out.println();
        }
    }
    
    public static void help(final int n, final int n2) {
        Main.out.println("Test Case: " + (n + 1) + " | Variable Output: " + n2);
    }
    
    public static void help(final int n, final String s) {
        Main.out.println("Test Case: " + (n + 1) + " | Variable Output: " + s);
    }
    
    public static void help(final int n, final char[] array) {
        Main.out.print("Test Case: " + (n + 1) + " | Variable Output: ");
        for (int length = array.length, i = 0; i < length; ++i) {
            Main.out.print("" + array[i]);
        }
        Main.out.println();
    }
    
    static class Node implements Comparable<Node>
    {
        public int x;
        public int y;
        
        public Node(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(final Node node) {
            if (this.x == node.x) {
                return 0;
            }
            if (this.x > node.x) {
                return 1;
            }
            return -1;
        }
        
        public boolean equals(final Node node) {
            return this.x == node.x;
        }
    }
    
    static class Edge implements Comparable<Edge>
    {
        public Node a;
        public Node b;
        public int weight;
        
        public Edge(final Node a, final Node b, final int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(final Edge edge) {
            if (this.weight == edge.weight) {
                return 0;
            }
            if (this.weight > edge.weight) {
                return 1;
            }
            return -1;
        }
    }
    
    public static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        String nextLine() {
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