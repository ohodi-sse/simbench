public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		
		char[] S = scan.next().toCharArray();


		
		int result = 0;

		for (int i = 0; i < 3; i++) {
			if (S[i] == 'R') {
				result++;
			}
		}

		if (result == 2 && S[1] == 'S') {
			result = 1;
		}

		
			System.out.println(result);
	}
}