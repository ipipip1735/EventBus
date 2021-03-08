package mine.eventbus.events;

import org.greenrobot.eventbus.util.HasExecutionScope;

/**
 * Created by Administrator on 2021/3/8.
 */
public class Service implements HasExecutionScope {
    Object executionScope;


    public Service() {
        System.out.println("~~" + getClass().getSimpleName() + ".Service~~");
    }

    @Override
    public Object getExecutionScope() {
        return executionScope;
    }

    @Override
    public void setExecutionScope(Object executionScope) {
        this.executionScope = executionScope;
    }
}
