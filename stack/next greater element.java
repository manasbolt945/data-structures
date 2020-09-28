class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Stack<Integer> s = new Stack<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int[] nums = new int[nums1.length];
        int[] arr = new int[nums2.length];
        for(int i=nums2.length-1; i>=0; i--)
        {
           
            while(!s.isEmpty() && nums2[i]>=s.peek())
                s.pop();
            arr[i]= s.isEmpty()?-1:s.peek();
            hm.put(nums2[i],arr[i]);
            s.push(nums2[i]);
        }
        int j=0;
        for(int i=0; i<nums1.length; i++)
        {
            nums[i]=hm.get(nums1[i]);
        }
        return nums;
    }
}
