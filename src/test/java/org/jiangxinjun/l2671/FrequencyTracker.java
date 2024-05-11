package org.jiangxinjun.l2671;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FrequencyTracker {

    private Map<Integer, Integer> frequencyTracker = new HashMap<>();

    private Map<Integer, List<Integer>> frequencyTrackerCountMap = new HashMap<>();

    public FrequencyTracker() {
    }

    public void add(int number) {
        Integer count = frequencyTracker.get(number);
        if (count == null) {
            frequencyTracker.put(number, 1);
            addNumber(1, number);
        } else {
            removeNumber(count, number);
            frequencyTracker.put(number, ++count);
            addNumber(count, number);
        }
    }

    public void deleteOne(int number) {
        Integer count = frequencyTracker.get(number);
        if (count == null) {
            return;
        }
        removeNumber(count, number);
        if (count - 1 <= 0) {
            frequencyTracker.remove(number);
            return;
        }
        frequencyTracker.put(number, --count);
        addNumber(count, number);
    }

    public boolean hasFrequency(int frequency) {
        return frequencyTrackerCountMap.containsKey(frequency);
    }

    private void addNumber(int key, int number) {
        frequencyTrackerCountMap.compute(key, (integer, integers) -> {
            if (integers == null) {
                integers = new ArrayList<>();
            }
            integers.add(number);
            return integers;
        });
    }

    private void removeNumber(int index, Integer number) {
        List<Integer> countList = frequencyTrackerCountMap.get(index);
        countList.remove(number);
        if (countList.isEmpty()) {
            frequencyTrackerCountMap.remove(index);
        }
    }
}
