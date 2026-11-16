class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        long max = 0;
        long sum = 0;
       
       for(int i = 0;i<nums.length;i++){
        int num = nums[i];
        while(set.contains(num) || set.size()==k){
            set.remove(nums[left]);
            sum -= nums[left];
            left++;
        }
        set.add(num);
        sum+=num;
        if(set.size()==k){
            max = Math.max(max,sum);
        }
       }
       return max;
    }
}