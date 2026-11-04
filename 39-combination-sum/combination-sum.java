class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        helper(0,result,list,candidates,target);
        return result;
    }public static void helper(int i,List<List<Integer>> result,ArrayList<Integer> list,int []candidates,int target){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
         if (i >= candidates.length || target < 0) {
            return; 
        }

        if(candidates[i]<=target){
            list.add(candidates[i]);
            helper(i,result,list,candidates,target-candidates[i]);
            list.remove(list.size()-1);
        }
        helper(i+1,result,list,candidates,target);
    }
}