public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int count = 0;






        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') count++;
            else count = 0;
            if (count > max) max = count;
        }

            System.out.println(max);

    }
    }