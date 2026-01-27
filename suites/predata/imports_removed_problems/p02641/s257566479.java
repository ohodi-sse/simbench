public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[] ps = new int[102];
		int nearest = 0;
		for (int i = 0; i < n; i++) {
			ps[sc.nextInt()] = 1;
		}
		
		for (int i = 0; i < 102; i++) {
			if (ps[i] == 1) {
				continue;
			}
			if (x - nearest > Math.abs(x - i)) {
				nearest = i;
			}
		}
		System.out.println(nearest);
	}
}