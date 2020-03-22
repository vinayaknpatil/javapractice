import java.util.Arrays;

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
  **/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Basic solution

        int[] result = new int[];

        // Now sort the array

        int [] sortedArray = Arrays.sort(nums);

        int firstIndex = -1;
        int secondIndex = -1;

        for(int i =0;i<sortedArray.length;i++)
        {
            int firstNum = sortedArray[i];

            if(firstNum > target)
                return result;

            int otherNum = target - firstNum;

            int secondIndex = findOtherIndex(i, otherNum,sortedArray);

            if(secondIndex > -1)
            {
                result[0] = firstIndex;
                result[1] = secondIndex;

                return result;
            }
        }

    }


    public int findOtherIndex(int i, int otherNum, int[] array)
    {
        for (int j=i+1; j < array.length; j++)
        {
            if (array[j] == otherNum)
                return j;
        }

        return -1;
    }
}
