public class Main {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);

		long A = sc.nextLong();
		BigDecimal B = sc.nextBigDecimal();
		int C = 100;

		BigDecimal bA = new BigDecimal(A);
		BigDecimal bC = new BigDecimal(C);

		B = B.multiply(bC); 
		BigDecimal pop = bA.multiply(B);
		pop = pop.divide(bC);
		pop = pop.setScale(0, BigDecimal.ROUND_DOWN);

		System.out.println(pop);
	}
}