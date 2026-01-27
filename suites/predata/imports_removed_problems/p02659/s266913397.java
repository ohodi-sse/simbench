public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().split(" ");

            br.close();

            BigDecimal x = new BigDecimal(in[0]);
            BigDecimal y = new BigDecimal(in[1]);

            System.out.println(x.multiply(y).toBigInteger());

        }
    }
}