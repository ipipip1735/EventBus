package mine.eventbus.events;

/**
 * Created by Administrator on 2021/3/3.
 */
public class TheEvent {
    public int age;

    public TheEvent() {
//        System.out.println("~~TheEvent~~");
    }

    public TheEvent(int age) {
//        System.out.println("~~TheEvent~~");
        this.age = age;
    }

    @Override
    public String toString() {
        return "TheEvent{" +
                "age=" + age +
                '}';
    }
}
