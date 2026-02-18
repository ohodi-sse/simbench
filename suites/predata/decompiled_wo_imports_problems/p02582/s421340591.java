final class Main
{
    private static BufferedReader f;
    private static PrintWriter out;
    private static StringTokenizer st;
    
    private static void main$3231c38a() throws IOException {
        Main.f = new BufferedReader(new InputStreamReader(System.in));
        Main.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final char[] charArray = Main.f.readLine().toCharArray();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                int n;
                for (n = i; n < 2 && charArray[n + 1] == 'R'; ++n) {}
                max = Math.max(max, n - i + 1);
            }
        }
        Main.out.println(max);
        Main.f.close();
        Main.out.close();
    }
    
    private static boolean[] generate(final int n, final int n2) {
        final boolean[] array = new boolean[n2];
        for (int i = 0; i < n2; ++i) {
            array[i] = ((n & 1 << i) >> i == 1);
        }
        return array;
    }
    
    private static boolean valid(int n, final char[][] array, final boolean[] array2, final boolean[] array3) {
        for (int i = 0; i < array2.length; ++i) {
            for (int j = 0; j < array3.length; ++j) {
                if (array2[i] && array3[i] && array[i][j] == '#') {
                    --n;
                }
            }
        }
        return n == 0;
    }
    
    private static int ni(final StringTokenizer stringTokenizer) {
        return Integer.parseInt(stringTokenizer.nextToken());
    }
    
    private static int ni() throws IOException {
        return Integer.parseInt(Main.f.readLine());
    }
    
    private static StringTokenizer nl() throws IOException {
        return new StringTokenizer(Main.f.readLine());
    }
    
    private static int[] nia(final int n) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(Main.f.readLine());
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        return array;
    }
    
    private static void setIn(final String fileName) throws IOException {
        Main.f = new BufferedReader(new FileReader(fileName));
    }
    
    private static void setOut(final String fileName) throws IOException {
        Main.out = new PrintWriter(new FileWriter(fileName));
    }
    
    private static void setIn() {
        Main.f = new BufferedReader(new InputStreamReader(System.in));
    }
    
    private static void setOut() {
        Main.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
    
    private static void setIO(final String s) throws IOException {
        Main.f = new BufferedReader(new FileReader(s + ".in"));
        Main.out = new PrintWriter(new FileWriter(s + ".out"));
    }
    
    private static void setIO() {
        Main.f = new BufferedReader(new InputStreamReader(System.in));
        Main.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
}