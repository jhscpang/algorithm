//Given an absolute path for a file (Unix-style), simplify it. Or in other words
//, convert it to the canonical path. 
//
// In a UNIX-style file system, a period . refers to the current directory. Furt
//hermore, a double period .. moves the directory up a level. For more information
//, see: Absolute path vs relative path in Linux/Unix 
//
// Note that the returned canonical path must always begin with a slash /, and t
//here must be only a single slash / between two directory names. The last directo
//ry name (if it exists) must not end with a trailing /. Also, the canonical path 
//must be the shortest string representing the absolute path. 
//
// 
//
// Example 1: 
//
// 
//Input: "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
// 
//
// Example 2: 
//
// 
//Input: "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// Example 4: 
//
// 
//Input: "/a/./b/../../c/"
//Output: "/c"
// 
//
// Example 5: 
//
// 
//Input: "/a/../../b/../c//.//"
//Output: "/c"
// 
//
// Example 6: 
//
// 
//Input: "/a//b////c/d//././/.."
//Output: "/a/b/c"
// 
// Related Topics String Stack

package leetcode.editor.en;

//Java：Simplify Path

import java.util.Stack;

public class P71SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new P71SimplifyPath().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            /**
             * 思路：利用栈存储需要最后拼接的路径
             */
            String[] s = path.split("/");
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < s.length; i++) {
                if (!stack.isEmpty() && s[i].equals("..")) { // 遇到返回上次目录字符，将上级目录弹出
                    stack.pop();
                } else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")) { // 过滤掉多余路径字符
                    stack.push(s[i]);
                }
            }
            if (stack.isEmpty()) {
                return "/";
            }

            StringBuffer res = new StringBuffer();
            while (!stack.isEmpty()) {
                res.insert(0, stack.pop());
                res.insert(0, "/");
            }
            return res.toString();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}