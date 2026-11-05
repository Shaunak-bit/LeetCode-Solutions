class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(0,result,list,candidates,target);
        return result;
    }public static void helper(int start ,List<List<Integer>>result,ArrayList<Integer> list,int[] candidates,int target){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return ;
        }
        for(int i = start;i<candidates.length;i++){
            if(candidates[i]>target ){
               continue;
            }
            if(i>start && candidates[i]==candidates[i-1]){
              continue;
            }
            list.add(candidates[i]);
            helper(i+1,result,list,candidates,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}