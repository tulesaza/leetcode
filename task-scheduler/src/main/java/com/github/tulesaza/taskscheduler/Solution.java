package com.github.tulesaza.taskscheduler;

class Solution {
    /* GIVEN:
     * 'B' - 4
     * 'A' - 3
     * 'C' - 2
     *  n = 3
     *  To complete only B, where i1-3 idle :
     *  B i1 i2 i3
     *  B i1 i2 i3
     *  B i1 i2 i3
     *  B
     *  But we can put A and C instead:
     *  B A C i3
     *  B A C i3
     *  B A i2 i3
     *  B
     * so cycles is (count(B) - 1) * (n + 1) + count(count(B)) - count of task with same frequency as B, so if 'A' - 4 then result is
     *  B A C i3
     *  B A C i3
     *  B A i2 i3
     *  B A
     *
     *
     */
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequency = new int[26];
        int maxFrequency = 0;
        for (char taskType : tasks) {
            taskFrequency[taskType - 'A']++;
            maxFrequency = Math.max(maxFrequency, taskFrequency[taskType - 'A']);
        }
        int maxFrequentCount = 0;
        for (int i = 0; i < 26; ++i) {
            if (taskFrequency[i] == maxFrequency) {
                maxFrequentCount++;
            }
        }

        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxFrequentCount);
    }

}