/**
 *多线程案例：生产者消费者
 */
class Messages {
    private String title;
    private String content;
    private  boolean flag=true;

    /**
     *
     * @param title
     * @param content
     */
    public synchronized void set(String title,String content){
        if(this.flag==false)
        {
            try {
                super.wait();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        try
        {
            Thread.sleep(100);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        this.title=title;
        this.content=content;
        this.flag=false;
       super.notify();
    }
    public synchronized void get(){
        if(this.flag==true)
        {
            try {
                super.wait();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        try
        {
            Thread.sleep(100);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("标题："+title+"\t内容："+content);
        this.flag=true;
        super.notify();
    }
}
class Producer implements Runnable {
    private Messages msg =null;
    public Producer(Messages msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        for(int x=0;x<50;x++)
        {
            if(x%2==0)
            {
            this.msg.set("A","a");
            }
            else
                this.msg.set("B","b");
        }
    }
}
class Consumer implements Runnable{
    private Messages msg =null;
    public Consumer(Messages msg){
        this.msg=msg;
    }

    @Override
    public void run() {
        for(int x=0;x<50;x++)
        {
            this.msg.get();
        }

    }
}
public class Text2 {
    public static void main(String[] args) {
        Messages msg= new Messages();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
