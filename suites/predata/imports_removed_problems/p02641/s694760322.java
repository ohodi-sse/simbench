public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int X = sc.nextInt();
		int N = sc.nextInt();
		
		if (N == 0) {
			System.out.println(X);
			sc.close();
			return;
		}
		
		Set<Integer> p = new HashSet<>();
		for (int i = 0; i < N; i++) {
			p.add(sc.nextInt());
		}
		
		
		for (int i = 0; i <= 100; i++) {
			if (!p.contains(X - i)) {
				System.out.println(X - i);
				break;
			}
			else if (!p.contains(X + i)) {
				System.out.println(X + i);
				break;
			}
		}

		sc.close();
	}
}