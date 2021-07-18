//problem can be found https://leetcode.com/problems/longest-common-prefix/
class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String pfix = strs[0]; // set pfix to strs
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(pfix) != 0) { // while loop till String is cut down till pfix is found or there is no
													// pfix
				pfix = pfix.substring(0, pfix.length() - 1);
				if (pfix.isEmpty())
					return "";
			}
		}
		return pfix;
	}
}