//Write a bash script to calculate the frequency of each word in a text file wor
//ds.txt. 
//
// For simplicity sake, you may assume: 
//
// 
// words.txt contains only lowercase characters and space ' ' characters. 
// Each word must consist of lowercase characters only. 
// Words are separated by one or more whitespace characters. 
// 
//
// Example: 
//
// Assume that words.txt has the following content: 
//
// 
//the day is sunny the the
//the sunny is is
// 
//
// Your script should output the following, sorted by descending frequency: 
//
// 
//the 4
//is 3
//sunny 2
//day 1
// 
//
// Note: 
//
// 
// Don't worry about handling ties, it is guaranteed that each word's frequency 
//count is unique. 
// Could you write it in one-line using Unix pipes? 
// 
//

package leetcode.editor.en;

//Java：Word Frequency
public class P192WordFrequency {
    public static void main(String[] args) {
        // TO TEST
    }

    //There is no code of Java type for this problem
    /**
     * 思路：先cat，然后缩减连续的空格换成换行符，每行排序，排完序之后相邻行去重，去重后按重复数排序，最后输出
     *
     * cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{print $2" "$1}'
     */
}