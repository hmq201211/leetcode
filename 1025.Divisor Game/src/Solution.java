class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public boolean divisorGame2(int N) {
        boolean[] resultSet = new boolean[N + 1];
        resultSet[1] = false;
        if (N <= 1)
            return false;
        else {
            resultSet[2] = true;
            for (int i = 3; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0 && !resultSet[i - j]) {
                        resultSet[i] = true;
                        break;
                    }

                }
            }
        }
        return resultSet[N];
    }
}