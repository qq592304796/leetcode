package org.jiangxinjun.l2671;

/**
 * @author jiangxinjun
 * @since 2024/3/21
 */
class FrequencyTracker2 {
    private static final int N = 100001;
    private int[] freq;
    private int[] freqCnt;

    public FrequencyTracker2() {
        freq = new int[N];
        freqCnt = new int[N];
    }

    public void add(int number) {
        --freqCnt[freq[number]];
        ++freq[number];
        ++freqCnt[freq[number]];
    }

    public void deleteOne(int number) {
        if (freq[number] == 0) {
            return;
        }
        --freqCnt[freq[number]];
        --freq[number];
        ++freqCnt[freq[number]];
    }

    public boolean hasFrequency(int frequency) {
        return freqCnt[frequency] > 0;
    }
}
