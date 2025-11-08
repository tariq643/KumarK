package kumarK.hashing;

import java.util.*;

public class ZScalarOABuildingReductionOptimal {

    private int zScalarOABuildingReduction (int[] nums) {

        Map<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        int steps = 0;

        List<Map.Entry<Integer, Integer>> g = new ArrayList<>(treeMap.entrySet());

        for (int i = 0; i < g.size() - 1; i++) {
            g.get(i + 1).setValue(g.get(i).getValue() + g.get(i + 1).getValue());
            steps = steps + g.get(i).getValue();
            g.get(i).setValue(0);
        }
        
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9,6,6,5,5,6,8,9};
        ZScalarOABuildingReductionOptimal zScalarOABuildingReduction = new ZScalarOABuildingReductionOptimal();
        System.out.println(zScalarOABuildingReduction.zScalarOABuildingReduction(nums));
    }
}
