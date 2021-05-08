/**
 * 案例：买票
 * 练习多线程及锁的概念达到资源共享。
 */
class MyThread5 implements Runnable
{
    private  int ticket=200;

    @Override
    public void run() {
         synchronized (this)
            {
                if(this.ticket>0)
                {
                   try{
                       Thread.sleep(100);
                   }catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
                    this.ticket--;
                   if(this.ticket==0)
                       System.out.println(Thread.currentThread().getName()+"进行买票：票已卖完");
                   else
                       System.out.println(Thread.currentThread().getName()+"进行买票：票数还剩："+this.ticket);
                }
            }
        }
    public int getTicket(){
        return this.ticket;
    }
}
public class Text {
    public static void main(String[] args)
    {
        MyThread5 m = new MyThread5();

        while (m.getTicket()>0)
        {
            new Thread(m,"售票口A").start();
            new Thread(m,"售票口B").start();
            new Thread(m,"售票口C").start();
            new Thread(m,"售票口D").start();
            new Thread(m,"网络售票").start();
        }
        return ;
    }

}
