class Solution {
    public List<String> generateParenthesis(int n) {
      ArrayList<String> list = new ArrayList<>();
      StringBuilder sb = new StringBuilder();

       helper(n,0,0,list,sb);  
       return list;
    }public static void helper(int n,int open , int close, ArrayList<String> list,StringBuilder sb){
        if(sb.length()==2*n){
             list.add(sb.toString());
             return;
        }
        
        if(open<n){
            sb.append('(');
            helper(n,open+1,close,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close<open){
           sb.append(')');
           helper(n,open,close+1,list,sb);
           sb.deleteCharAt(sb.length()-1);
        }
    } 
}