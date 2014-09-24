
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Eric Yang 2014-01-13
 */
class WordsComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1<o2)
			return 1;
		else if(o1>o2)
			return -1;
		else
			return 0;
	}
}

public class AsperaWordProblem {
	//The longest(second longest) word in the file that can be constructed
	private String firstLongestWord = null, secondLongestWord = null;
	private int count = 0; //The number of words can be constructed

	// This HashMap structure is to store all the words with different length.
	// key(Integer) is the length of the words in the set, value is the set of
	// words with the same(key) length
	private TreeMap<Integer, HashSet<String>> wordsMap = new TreeMap<Integer, HashSet<String>>(new WordsComparator());//use custom comparator to sort words from longest to shortest
	
	// Use DP solution, first make dp[length] = true, than from last to first,
	// if the subWord can find, so dp[index] be true, index is the start position of each
	// subWord.
	private boolean isWordConstructed(String s) {
		if (s == null)
			return false;
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[len] = true;
		HashSet<String> dict = new HashSet<String>();
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 1; j <= len; j++) {
				if(dp[j] == false || (j - i)>=len) //if last j index is not true, continue next
					continue;
				String subWord = s.substring(i, j);
				dict = wordsMap.get(j - i); // get the set of words which has j-i length
				if (dict != null && dict.contains(subWord)) {
					dp[i] = true;
					break; //find from index i can be constructed word
				}
			}
		}
		return dp[0]; // if the dp[0]==true, means this word can constructed by
						// other words
	}

	public void getConstructedWords() {
		// Iterator the treeMap(wordsMap) from the longest words to the shortest words
		for (Map.Entry<Integer, HashSet<String>> entry : wordsMap.entrySet()) {
			HashSet<String> wordsSet = entry.getValue(); // A wordsSet only contains
												         // same length of words
			for (String word : wordsSet) {
				if (isWordConstructed(word) == true) {
					count++;
					if (count == 1) //first word can be constructed
						firstLongestWord = word;
					else if(count == 2) //second word can be constructed
						secondLongestWord = word;
				}
			}
		}
	}
	
	public void addWord(String word){
		int length = word.length();
		HashSet<String> wordsSet = wordsMap.get(length);
		if(wordsSet == null){
			wordsSet = new HashSet<String>();
		}
		wordsSet.add(word);
		wordsMap.put(length, wordsSet);
	}
	
	public String getFirstLongestWord(){
		return firstLongestWord;
	}
	
	public String getSecondLongestWord(){
		return secondLongestWord;
	}
	
	public int getConstructedWordsNumber(){
		return count;
	}
}


//For test///
//AsperaWordProblem solution = new AsperaWordProblem();
//BufferedReader br;
//br = new BufferedReader(new FileReader("wordsforproblem.txt"));
//String word;
//while ((word = br.readLine()) != null) {
//	// process the each word
//	solution.addWord(word);
//}
//br.close();
//solution.getConstructedWords();
//String str1 = solution.getFirstLongestWord();
//String str2 = solution.getSecondLongestWord();
//int nd = solution.getConstructedWordsNumber();
