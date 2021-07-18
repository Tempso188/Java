//problem can be found under https://leetcode.com/problems/search-insert-position/
class Solution {
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2; // 1. Pointer in the middle, afterwards pointer in the middle of the rest
												// to check
			if (target == nums[mid]) { // check if target is at mid
				return mid;
			} else if (target > nums[mid]) { // check if target is bigger than mid
				low = mid + 1; // if bigger then set lower boundary to mid+1
			} else {
				high = mid - 1; // if less then set upper boundary to mid-1
			} // while breaks when upper and lower boundary are the same
		}
		return low; // return index at which the number should have been
	}
}