import java.util.*;

class Leetcode {
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        
        //Check input and call DFS
        if(digits != null && digits.length() > 0){
            String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            dfs(digits, map, result, new StringBuilder(), 0);
        }
        return result;
    }
    
    private static void dfs(String digits, String[] map, ArrayList<String> result, StringBuilder sb, int index){
        //base case for dfs to exit recursion
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        int digit = Character.getNumericValue(digits.charAt(index));
        String letters = map[digit];
        
        //Adding each letter to the string we've built so far
        for(int i = 0; i < letters.length(); i++){
            char c = letters.charAt(i);
            sb.append(c);
            dfs(digits, map, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(Leetcode.letterCombinations("234"));
    }
}
/*
Time: O(n)
Space: O(n)
*/