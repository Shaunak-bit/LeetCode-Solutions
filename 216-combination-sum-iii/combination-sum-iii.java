class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> result = new ArrayList<>();
       ArrayList<Integer> list = new ArrayList<>();
       helper(1,result,list,k,n);
       return result;
    }public static void helper(int start, List<List<Integer>>result,ArrayList<Integer>list,int k,int n){
        if(n==0 && list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
         if (n < 0 || list.size() >= k) {
            return;
        }
        for(int i = start;i<=9;i++){
            list.add(i);
            helper(i+1,result,list,k,n-i);
            list.remove(list.size()-1);
        }
    }
}