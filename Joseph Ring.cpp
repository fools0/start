#include <stdio.h>
#include <stdlib.h>
typedef struct Node
{
    int data;
    struct Node *next;
} Node;
 
//创建解约瑟夫环需要的链表，该链表不带头节点
Node *CreatList(int Length)
{
    Node *head, *p, *temp;
    int i = 0;
    //先创建普通链表
    head = (Node *)malloc(sizeof(Node)), head->data = -1; //为创建链表方便，暂时加上头结点
    p = head;
 
   
    for (i = 1; i <= Length; i++)
    {
        p->next = (Node *)malloc(sizeof(Node));
        p = p->next;
        p->data = i;
    }
    p->next = NULL;
    /*普通链表转不带头结点的循环链表，就是将头指针下移到第一个节点位置
原来的头结点删掉，剩最后一个节点的判断条件就是head == head->next*/
    temp = head;          
    p->next = head->next; 
    head = head->next;    
    free(temp);           
    return head;         
}
 
int main(void)
{
    Node *head, *p, *temp;
    int n,m,k,i; //n人数  m  第m个人 k 叫到K的删除 
    int x=1;        
 
   
    head = p = temp = NULL;
    //输入数据
    printf("请按照n,m,k的顺序来输入数值\n"); 
    scanf("%d%d%d", &n,&m,&k);
    //创建链表
    head = CreatList(n);
	p = head;
    while(x<m)//找到第m个人 
	{
		p=p->next;
		x++;
	}
    
    while (p != p->next) //不是只有一个元素时
    {
        for (i = 1; i < k - 1; i++)
            p = p->next;
        if (p != p->next) //不是最后一个元素时
        {
            temp = p->next;
            p->next = temp->next;
            printf("%d ", temp->data);
            free(temp);
            p = p->next;
        }
    }
    printf("%d\n", p->data);//输出最后一个元素 
    return 0;
}
