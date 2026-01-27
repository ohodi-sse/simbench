public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BigDecimal A = sc.nextBigDecimal();
        BigDecimal B = sc.nextBigDecimal();
        sc.close();
        System.out.println(A.multiply(B).toBigInteger());
    }
}