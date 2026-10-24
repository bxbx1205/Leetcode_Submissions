class Solution {

    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int month(String s) {
        String temp = "";
        temp += s.charAt(0);
        temp += s.charAt(1);

        return Integer.parseInt(temp);
    }

    public int day(String s) {
        String temp = "";
        temp += s.charAt(3);
        temp += s.charAt(4);

        return Integer.parseInt(temp);
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                  String arriveBob, String leaveBob) {

        int aliceArriveMonth = month(arriveAlice);
        int aliceLeaveMonth = month(leaveAlice);
        int aliceArriveDay = day(arriveAlice);
        int aliceLeaveDay = day(leaveAlice);

        int bobArriveMonth = month(arriveBob);
        int bobLeaveMonth = month(leaveBob);
        int bobArriveDay = day(arriveBob);
        int bobLeaveDay = day(leaveBob);

        int aliceStart = getDays(aliceArriveMonth, aliceArriveDay);
        int aliceEnd = getDays(aliceLeaveMonth, aliceLeaveDay);

        int bobStart = getDays(bobArriveMonth, bobArriveDay);
        int bobEnd = getDays(bobLeaveMonth, bobLeaveDay);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    public int getDays(int m, int d) {
        int total = d;

        for (int i = 0; i < m - 1; i++) {
            total += month[i];
        }

        return total;
    }
}