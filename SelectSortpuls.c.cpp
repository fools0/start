#include<stdio.h> 
void swap(int &a,int &b)
{
	int t;
	t=a;
	a=b;
	b=t;
}
void SelectSort(int a[],int n) //ѡ������
{
    int left = 0;
    int right = n - 1;
    while (left < right)
    {
        int min = left;
        int max = right;
        for (int i = left; i <= right; i++)
        {
            if (a[i] < a[min])
                min = i;
            if (a[i] > a[max])
                max = i;
        }
        // ������������������ֵ����Сλ�ã���Сֵ�����λ��
        swap(a[max], a[right]);
        if (min == right)
            min = max;
        swap(a[min], a[left]);
        left++;
        right--;
	}
}
int main()
{
	int a[10] = {43, 65, 4, 23, 6, 98, 2, 65, 7, 79};
	printf("ѡ������\n");
	SelectSort(a,10);
	for(int i=0;i<10;i++)
		printf(" %d ",a[i]);
    printf("\n");
    return 0;
}
