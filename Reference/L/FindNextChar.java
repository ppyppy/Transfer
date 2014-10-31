/** 
* Return the smallest character that is strictly larger than the search character, 
* If no such character exists, return the smallest character in the array 
* @param sortedStr : sorted list of letters, sorted in ascending order. 
* @param c : character for which we are searching. 
* Given the following inputs we expect the corresponding output: 
* ['c', 'f', 'j', 'p', 'v'], 'a' => 'c' 
* ['c', 'f', 'j', 'p', 'v'], 'c' => 'f' 
* ['c', 'f', 'j', 'p', 'v'], 'k' => 'p' 
* ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case 
* ['c', 'f', 'k'], 'f' => 'k' 
* ['c', 'f', 'k'], 'c' => 'f' 
* ['c', 'f', 'k'], 'd' => 'f' 
*/

	public static char findNextChar(char[] list, char c) {
		assert list.length > 0;
		int left = 0, right = list.length - 1;
		if(list[right]<c) //right most, than return smallest one, turnover
			return list[0];
		char result = list[0];
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (list[mid] == c) {
				if (mid < list.length - 1) return list[mid+1];
				else return result;
			}
			else if (list[mid] < c) {
				left = mid + 1;
			}
			else {//list[mid] > c 
				result = list[mid];
				right = mid - 1;
			}
		}
		return result;
	}