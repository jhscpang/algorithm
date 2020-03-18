//Given a text file file.txt, transpose its content. 
//
// You may assume that each row has the same number of columns and each field is
// separated by the ' ' character. 
//
// Example: 
//
// If file.txt has the following content: 
//
// 
//name age
//alice 21
//ryan 30
// 
//
// Output the following: 
//
// 
//name alice ryan
//age 21 30
// 
//
// 
//


package leetcode.editor.en;

//Java：Transpose File
public class P194TransposeFile {
    public static void main(String[] args) {
        // TO TEST
    }
    
    //There is no code of Java type for this problem
    /**
     * awk是按行读取记录并处理的，因此函数会应用到每行上。
     * 其中NF代表当前行上包含几个字段，NR代表当前行的行号
     * 处理逻辑是：分别对行上每个字段进行循环，如果是第一行，则放在二维数组首部，如果是其他行，则追加在二维数组上
     * 最后输出二维数组
     * awk '{
     *         for (i = 1; i<= NF; i++) {
     *             if (NR == 1) {
     *                 res[i] = $i
     *             } else {
     *                 res[i] = res[i]" "$i
     *             }
     *         }
     *     } END {
     *     for (j = 1; j <= NF; j++) {
     *         print res[j]
     *     }
     * }' file.txt
     */
}