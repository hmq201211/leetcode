class Solution {
    public int[] countBits(int num) {// 最高有效位
        int[] answer = new int[num + 1];
        int i = 0;
        int b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {
                answer[i + b] = answer[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return answer;
    }

    public int[] countBits_2(int num) {// 最低有效位
        int[] answer = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            answer[i] = answer[i >> 1] + (i & 2);
        }
        return answer;
    }

    public int[] countBits_3(int num) {// 最后设置位
        int[] answer = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            answer[i] = answer[i & (i - 1)] + 1;
        }
        return answer;
    }

    public int[] countBits_4(int num) {// 奇偶性分析 奇数:比前面的偶数多1, 偶数: 和偶数/2一样多
        int[] answer = new int[num + 1];
        answer[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                answer[i] = answer[i / 2];
            } else {
                answer[i] = answer[i - 1] + 1;
            }
        }
        return answer;
    }

}