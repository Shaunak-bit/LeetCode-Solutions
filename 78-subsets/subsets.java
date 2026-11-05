class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        helper(0,result,list,nums);
        return result;
    }public static void helper(int i,List<List<Integer>>result,ArrayList<Integer> list,int[] nums){
        if(i==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(i+1,result,list,nums);
        list.remove(list.size()-1);
        helper(i+1,result,list,nums);
    }
}