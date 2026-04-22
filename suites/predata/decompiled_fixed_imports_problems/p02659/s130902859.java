import java.math.BigInteger;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws Exception {
        final String[] split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        final BigInteger bigInteger = new BigInteger(split[0]);
        final String[] split2 = split[1].split("\\.");
        BigInteger val;
        if (split2[0].equals("0")) {
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
        final BigInteger val2 = new BigInteger("100");
        final BigInteger multiply = bigInteger.multiply(val);
        if (multiply.compareTo(val2) < 0) {
            System.out.println("0");
        }
        else {
            final String string = multiply.toString();
            System.out.println(string.substring(0, string.length() - 2));
        }
    }
}