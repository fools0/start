package J003;
import java.util.Scanner;
public class Bubble_sort {
	public static void main(String angs[]){
		int i;
		int num[]= new int [10];
		Scanner scanner = new Scanner(System.in);
		for(i=0;i<10;i++)
			num[i]=scanner.nextInt();
		fun(num);
		
		for(i=0;i<10;i++)
		{
			System.out.printf("%d ",num[i]);
			
		}
	}
	public static void fun(int num[])
	{
		int t,n;
		int i,j;
		n=num.length;
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(num[j]>num[i])
				{
					t=num[j];
					num[j]=num[i];
					num[i]=t;
				}
			}
		}
			 
		
	}
}
