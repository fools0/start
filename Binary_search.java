package J003;
import java.util.Arrays;
import java.util.Scanner;
public class Binary_search {
	public static void main(String[] args){
		int num[]={1,4,7,9,8,6,5,252,342,1235,13564,100,5,636};
		Scanner scanner = new Scanner(System.in);
		int value=scanner.nextInt();
		Arrays.sort(num);
		int n=Binary(num,value);
		for(int i=0;i<num.length;i++)
		{
			System.out.printf("%d ",num[i]);
		}
		if(n==-1)
			System.out.println("\n没有找到该元素\n");
		else
			System.out.printf("\n该元素在数组的第%d位\n",n+1);
		}
		
	

	public static int Binary(int num[],int value){
		
		int low=0;
		int high=num.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(value==num[mid])
				return mid;
			
			if(value>num[mid])
			low=mid+1;
			
			if(value<num[mid])
				high=mid-1;
				
		}
			return -1;
}
}