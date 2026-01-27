public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);


        long a = in.nextLong();


        BigDecimal b = new BigDecimal(String.valueOf(in.nextDouble()));
        b = b.multiply(new BigDecimal(String.valueOf(a)));

        String s = b.toString();
        System.out.println(s.substring(0, s.indexOf(".")));
    }
}