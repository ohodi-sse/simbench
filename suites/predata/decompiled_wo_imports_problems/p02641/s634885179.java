public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String[] split = bufferedReader.readLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        final TreeSet set = new TreeSet();
        for (int i = 0; i <= 101; ++i) {
            set.add(i);
        }
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int j = 0; j < int2; ++j) {
            set.remove(new Integer(Integer.parseInt(split2[j])));
        }
        final int intValue = set.floor(int1);
        final int intValue2 = set.ceiling(int1);
        if (Math.abs(intValue - int1) < Math.abs(intValue2 - int1)) {
            printWriter.println(intValue);
        }
        else if (Math.abs(intValue - int1) > Math.abs(intValue2 - int1)) {
            printWriter.println(intValue2);
        }
        else {
            printWriter.println(Math.min(intValue, intValue2));
        }
        printWriter.flush();
        printWriter.close();
    }
}