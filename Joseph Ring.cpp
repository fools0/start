#include <stdio.h>
#include <stdlib.h>
typedef struct Node
{
    int data;
    struct Node *next;
} Node;
 
//������Լɪ����Ҫ��������������ͷ�ڵ�
Node *CreatList(int Length)
{
    Node *head, *p, *temp;
    int i = 0;
    //�ȴ�����ͨ����
    head = (Node *)malloc(sizeof(Node)), head->data = -1; //Ϊ���������㣬��ʱ����ͷ���
    p = head;
 
   
    for (i = 1; i <= Length; i++)
    {
        p->next = (Node *)malloc(sizeof(Node));
        p = p->next;
        p->data = i;
    }
    p->next = NULL;
    /*��ͨ����ת����ͷ����ѭ���������ǽ�ͷָ�����Ƶ���һ���ڵ�λ��
ԭ����ͷ���ɾ����ʣ���һ���ڵ���ж���������head == head->next*/
    temp = head;          
    p->next = head->next; 
    head = head->next;    
    free(temp);           
    return head;         
}
 
int main(void)
{
    Node *head, *p, *temp;
    int n,m,k,i; //n����  m  ��m���� k �е�K��ɾ�� 
    int x=1;        
 
   
    head = p = temp = NULL;
    //��������
    printf("�밴��n,m,k��˳����������ֵ\n"); 
    scanf("%d%d%d", &n,&m,&k);
    //��������
    head = CreatList(n);
	p = head;
    while(x<m)//�ҵ���m���� 
	{
		p=p->next;
		x++;
	}
    
    while (p != p->next) //����ֻ��һ��Ԫ��ʱ
    {
        for (i = 1; i < k - 1; i++)
            p = p->next;
        if (p != p->next) //�������һ��Ԫ��ʱ
        {
            temp = p->next;
            p->next = temp->next;
            printf("%d ", temp->data);
            free(temp);
            p = p->next;
        }
    }
    printf("%d\n", p->data);//������һ��Ԫ�� 
    return 0;
}
