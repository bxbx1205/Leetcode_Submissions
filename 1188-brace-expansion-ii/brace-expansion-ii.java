class Solution {

    String s;
    int idx;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        idx = 0;

        Set<String> set = union();

        return new ArrayList<>(set);
    }

    private Set<String> union() {

        Set<String> result = new TreeSet<>();

        while (true) {

            Set<String> temp = concat();

            result.addAll(temp);

            if (idx < s.length() && s.charAt(idx) == ',') {
                idx++;
            } else {
                break;
            }
        }

        return result;
    }

    private Set<String> concat() {

        Set<String> result = new TreeSet<>();

        result.add("");

        while (idx < s.length()
                && s.charAt(idx) != ','
                && s.charAt(idx) != '}') {

            Set<String> temp = unit();

            Set<String> newResult = new TreeSet<>();

            for (String a : result) {
                for (String b : temp) {
                    newResult.add(a + b);
                }
            }

            result = newResult;
        }

        return result;
    }

    private Set<String> unit() {

        Set<String> result;

        if (s.charAt(idx) == '{') {

            idx++;

            result = union();

            idx++;

        } else {

            result = new TreeSet<>();
            result.add(String.valueOf(s.charAt(idx)));

            idx++;
        }

        return result;
    }
}