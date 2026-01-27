public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int ans = x;

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		for (int dif = 0; dif <= n; dif++) {

			
			if (!list.contains(x - dif)) {
				ans = x - dif;
				break;
			}

			
			if (!list.contains(x + dif)) {
				ans = x + dif;
				break;
			}

		}

		if (n > 100) {
			System.out.println("error");
		}
		System.out.println(ans);

		sc.close();

	}

}