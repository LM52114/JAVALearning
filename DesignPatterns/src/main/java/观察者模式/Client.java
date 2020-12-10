package 观察者模式;

/**
 * @Author Li Hao
 * @Date 2020/12/10 21:22
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {

        //定义两个不同的观察者，分别执行不同的操作
        Observer observer1=new Observer() {
            @Override
            public void update() {
                System.out.println("this is Observer1");
            }
        };
        Observer observer2=new Observer() {
            @Override
            public void update() {
                System.out.println("this is Observer2");
            }
        };

        //定义一个主题对象，用来管理观察者
        Subject subject=new Subject();

        //增加观察者
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        //满足一定条件时通知所有观察者
        for (int i = 0; i <3 ; i++) {
            System.out.println(i);
            if(i==1){
                subject.fireAllObservers();
            }
        }
    }
}
