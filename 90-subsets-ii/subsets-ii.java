class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(0,nums,result,list);
        return result;
    }public static void helper(int start,int[] nums,List<List<Integer>>result,ArrayList<Integer>list){
       
            result.add(new ArrayList<>(list));
            
        
        for(int i = start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            helper(i+1,nums,result,list);
            list.remove(list.size()-1);
        }
    }
}