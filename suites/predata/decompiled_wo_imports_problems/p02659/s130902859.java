public final class Main
{
    private static void main$3231c38a() throws Exception {
        final String[] split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        final BigInteger bigInteger = new BigInteger(split[0]);
        final String[] split2;
        BigInteger val;
        if ((split2 = split[1].split("\\."))[0].equals("0")) {
            if (split2[1].startsWith("0")) {
                val = new BigInteger(split2[1].substring(1));
            }
            else {
                val = new BigInteger(split2[1]);
            }
        }
        else {
            val = new BigInteger(split2[0] + split2[1]);
        }
        final BigInteger multiply;
        if ((multiply = bigInteger.multiply(val)).compareTo(new BigInteger("100")) < 0) {
            System.out.println("0");
            return;
        }
        final String string = multiply.toString();
        System.out.println(string.substring(0, string.length() - 2));
    }
}