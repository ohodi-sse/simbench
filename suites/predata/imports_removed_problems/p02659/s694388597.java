public class Main {

	public static void main(String[] args) {
		

		Scanner scan =new Scanner(System.in);
		BigDecimal A = scan.nextBigDecimal();
		BigDecimal B= scan.nextBigDecimal();
		BigDecimal seki = B.multiply(A);
		long C = seki.longValue();
		System.out.println(C);
	}
}