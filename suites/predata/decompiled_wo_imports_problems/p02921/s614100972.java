public final class Main
{
    private static <T> List<List<T>> zip(final List<T>... array) {
        final ArrayList list = new ArrayList();
        final int length = array.length;
        for (int i = 0; i < 2; ++i) {
            final List<T> list2 = array[i];
            for (int j = 0; j < list2.size(); ++j) {
                Object o;
                if (j >= list.size()) {
                    list.add(o = new ArrayList<T>());
                }
                else {
                    o = list.get(j);
                }
                ((List<T>)o).add(list2.get(j));
            }
        }
        return list;
    }
    
    private static List<Character> toCharacterList(final String s) {
        if (s == null) {
            return null;
        }
        final int length = s.length();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < length; ++i) {
            list.add(s.charAt(i));
        }
        return list;
    }
    
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List[] array = { toCharacterList(bufferedReader.readLine()), toCharacterList(bufferedReader.readLine()) };
        final ArrayList list = new ArrayList();
        final int length = array.length;
        for (int i = 0; i < 2; ++i) {
            final List list2 = array[i];
            for (int j = 0; j < list2.size(); ++j) {
                Object o;
                if (j >= list.size()) {
                    list.add(o = new ArrayList<Object>());
                }
                else {
                    o = list.get(j);
                }
                ((List<Object>)o).add(list2.get(j));
            }
        }
        final ArrayList list3 = list;
        int x = 0;
        for (final List list4 : list3) {
            if (((Character)list4.get(0)).equals(list4.get(1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}