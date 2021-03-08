package mine.eventbus.events;

/**
 * Created by Administrator on 2021/3/6.
 */
public class OneEvent {
    public int age;

    public OneEvent() {
//        System.out.println("~~TheEvent~~");
    }

    public OneEvent(int age) {
//        System.out.println("~~TheEvent~~");
        this.age = age;
    }

    @Override
    public String toString() {
        return "OneEvent{" +
                "age=" + age +
                '}';
    }
}
