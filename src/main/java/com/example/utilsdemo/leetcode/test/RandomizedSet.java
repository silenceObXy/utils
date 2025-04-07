package com.example.utilsdemo.leetcode.test;

import org.elasticsearch.common.collect.List;

import java.util.*;

/**
 * @Author: xy
 * @Date: 2024-10-30 16:30
 * @Description:
 */
class RandomizedSet {
    ArrayList<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(1,1);
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(23);
        randomizedSet.insert(4);
        randomizedSet.remove(5);
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet);
    }
}
