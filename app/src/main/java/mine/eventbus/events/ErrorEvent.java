package mine.eventbus.events;

/**
 * Created by Administrator on 2021/3/8.
 */
public class ErrorEvent {

    public ErrorEvent(Throwable throwable) {
        System.out.println("~~TheEvent~~");
        System.out.println("throwable = " + throwable);
    }
}
