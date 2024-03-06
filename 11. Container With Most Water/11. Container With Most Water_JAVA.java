class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            int leftNum = height[leftPointer];
            int rightNum = height[rightPointer];
            if (leftNum > rightNum) {
                maxWater = Math.max(maxWater, (rightPointer - leftPointer) * rightNum);
                rightPointer--;
            } else {
                maxWater = Math.max(maxWater, (rightPointer - leftPointer) * leftNum);
                leftPointer++;
            }
        }
        return maxWater;
    }
}