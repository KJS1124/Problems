package divideandconquer;
/**
 * @author KJS1124
 * Time Complexity O(nLogn)
 * Auxiliary Space: O(n)
 * Problem link http://www.spoj.com/problems/MAXSUMSU/
 */
public class MaximumSumSubArray {

	public int maxiumumSum(int arr[],int start,int end)
	{
		if(start==end)
			return arr[start];
		int mid=(start+end)/2;
		return Math.max(maxiumumSum(arr, start, mid),Math.max(maxiumumSum(arr, mid+1, end), maximumCrossSum(arr,start,mid,end)));
	}
	
	public int maximumCrossSum(int arr[],int start,int mid,int end)
	{
		int leftSum = Integer.MIN_VALUE;
		int sum =0 ;
		for(int i =mid;i>=start;i--)
		{
			sum+=arr[i];
			if(leftSum<sum)
				leftSum = sum;
		}
		sum=0;
		int rightSum=Integer.MIN_VALUE;
		for(int i=mid+1;i<=end;i++)
		{
			sum+=arr[i];
			if(rightSum<sum)
				rightSum = sum;
		}
		return leftSum + rightSum;
	}
	
	public static void main(String agrs[]) {
		int arr[] = {2, 3, 4, 5, 7};
		MaximumSumSubArray maximumSumSubArray = new MaximumSumSubArray();
		System.out.println(maximumSumSubArray.maxiumumSum(arr, 0, arr.length-1));
	}
}
