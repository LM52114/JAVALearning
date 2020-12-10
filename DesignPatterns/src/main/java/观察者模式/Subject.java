package 观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Li Hao
 * @Date 2020/12/10 21:19
 * @Version 1.0
 */
public class Subject {
    private List<Observer> observers= new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.add(observer);
    }

    public void fireAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
