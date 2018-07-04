import java.util.Date;

/**
 * output: 程序运行后，每秒输出一次时间，十秒后结束
 * thread.interrupt(); 不常用 //等当前执行完再中断
 * thread.stop(); //强行中断,类似于任务管理器中强行中断进程
 */
public class TestThreadInterruptedException {
    public static void main(String[] args){
        MyThread thread = new MyThread();
        thread.start();  //thread 线程启动
        try{
            Thread.sleep(10000);    //主线程（Thread）睡10秒
        }catch (InterruptedException e){}
        thread.interrupt();     //强行中断 thread线程，并结束
    }
}

class MyThread extends Thread{
    public void run(){
        while(true){ //无限循环
            System.out.println("==="+new Date()+"==="); //输出当前时间
            try{
                sleep(1000);//睡眠一秒，
            }catch (InterruptedException e){
                return; //强行中断此方法
            }
        }
    }
}
