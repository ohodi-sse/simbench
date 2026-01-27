public class Main {

	public static void main(String[] args) {

		
		Scanner s = new Scanner(System.in);


		int numx = s.nextInt();
		int numn = s.nextInt();

		if(numn == 0) {

			System.out.println(numx);

			s.close();

			System.exit(0);
		}
		Integer[] array = new Integer[numn];

		for(int i = 0 ; i < numn ; i++) {

			array[i] = s.nextInt();

		}

		
		List<Integer> listNum = Arrays.asList(array);

		
		s.close();

		
		int ans = 0;

		boolean flg_con = true;

		if(! listNum.contains(numx)) {
			
			ans = numx;
			
			flg_con = false;
		}

		int count = 0;

		while(flg_con) {

			count++;

			int mnx = numx - count;
			int plx = numx + count;

			if(! listNum.contains(mnx)) {

				ans = mnx;

				flg_con = false;
			}else if (! listNum.contains(plx)) {

				ans = plx;

				flg_con=false;
			}

		}

		System.out.println(ans);
	}

}