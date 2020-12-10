class Solution{
    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> temp, String s, int start){
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    temp.add(s.substring(start, i + 1));
                    dfs(result, temp, s, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
                high--;
                low++; 
        }
        return true;
    }
}