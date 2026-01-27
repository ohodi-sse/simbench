class Main{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int N = sc.nextInt();

		ArrayList<Integer> lstA;

		lstA = new ArrayList<Integer>();

		for (int i=0; i < N; i++) {
			int x = sc.nextInt();
			lstA.add(x);





		}

		Collections.sort(lstA);

		if (N==0 || !lstA.contains(X)) {
			System.out.println(X);
			return;
		}

		int idx=1;

		while (true) {

			int minus = X - idx;
			int plus = X + idx;

			if (lstA.contains(minus) && lstA.contains(plus)) {
				idx++;
				continue;
			}

			if (!lstA.contains(minus) && !lstA.contains(minus)) {
				System.out.println(minus);
				break;
			} else if (!lstA.contains(minus)) {
				System.out.println(minus);
				break;
			} else {
				System.out.println(plus);
				break;
			}
		}


	}
}