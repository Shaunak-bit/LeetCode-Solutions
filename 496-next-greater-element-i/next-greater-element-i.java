class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];

        for(int i = 0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for(int i=0;i<result.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}