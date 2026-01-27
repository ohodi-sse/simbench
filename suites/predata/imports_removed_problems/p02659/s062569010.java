public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		long A = sc.nextLong();
		double B = sc.nextDouble();
		
		if (B == 0) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		long C = Math.round(B * 100);
		long D = A * C;

		
		System.out.println(Math.floorDiv(D, 100));

		sc.close();
	}
}