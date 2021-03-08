package mine.eventbus.events;

/**
 * Created by Administrator on 2021/3/8.
 */
public class RxEvent {
    public int age;

    public RxEvent() {
//        System.out.println("~~TheEvent~~");
    }

    public RxEvent(int age) {
//        System.out.println("~~TheEvent~~");
        this.age = age;
    }

    @Override
    public String toString() {
        return "RxEvent{" +
                "age=" + age +
                '}';
    }
}
