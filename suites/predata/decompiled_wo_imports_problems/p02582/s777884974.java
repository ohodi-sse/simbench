public final class Main
{
    private static pair[] a;
    private static int[][] memo;
    private static int maxSize;
    private static boolean[][] exist;
    private static ArrayList<Integer>[] startAt;
    private static ArrayList<Integer>[] endAt;
    
    private static int dp(final int n, final int n2) {
        if (n > n2) {
            return 0;
        }
        throw new NullPointerException();
    }
    
    private static void main$3231c38a() throws NumberFormatException, IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final char[] charArray;
        if ((charArray = bufferedReader.readLine().toCharArray())[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            printWriter.println(3);
        }
        else if ((charArray[0] == 'R' && charArray[1] == 'R') || (charArray[1] == 'R' && charArray[2] == 'R')) {
            printWriter.println(2);
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            printWriter.println(1);
        }
        else {
            printWriter.println(0);
        }
        printWriter.flush();
        printWriter.close();
    }
    
    private static void compress(final pair[] array) {
        final TreeSet set = new TreeSet();
        for (int i = 0; i < array.length; ++i) {
            set.add(array[i].x);
            set.add(array[i].y);
        }
        set.add(0);
        set.add(1000000000);
        final HashMap hashMap = new HashMap();
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            hashMap.put((int)iterator.next(), hashMap.size());
        }
        for (int j = 0; j < array.length; ++j) {
            array[j].x = (int)hashMap.get(array[j].x);
            array[j].y = (int)hashMap.get(array[j].y);
        }
        hashMap.size();
    }
    
    static final class pair implements Comparable<pair>
    {
        int x;
        int y;
        
        private pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        private int compareTo(final pair pair) {
            return this.y - this.x - (pair.y - pair.x);
        }
    }
}