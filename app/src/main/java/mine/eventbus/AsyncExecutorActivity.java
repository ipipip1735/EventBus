package mine.eventbus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.util.AsyncExecutor;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

import mine.eventbus.events.ErrorEvent;
import mine.eventbus.events.Service;

/**
 * Created by Administrator on 2021/3/8.
 */
public class AsyncExecutorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EventBus.builder()
                .installDefaultEventBus()
                .register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("*********  " + getClass().getSimpleName() + ".onStart  *********");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onRestoreInstanceState  *********");

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("*********  " + getClass().getSimpleName() + ".onRestart  *********");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("*********  " + getClass().getSimpleName() + ".onResume  *********");
    }

    @Override
    protected void onPause() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onPause  *********");

        super.onPause();
    }

    @Override
    public void onBackPressed() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onBackPressed  *********");

        super.onBackPressed();
    }


    @Override
    protected void onStop() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onStop  *********");

        super.onStop();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onSaveInstanceState  *********");

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onDestroy  *********");
        EventBus.getDefault().unregister(this);


        super.onDestroy();
    }


    public void start(View view) {
        System.out.println("~~button.start~~");

//        AsyncExecutor asyncExecutor = AsyncExecutor.create();//????????????????????????????????????Application?????????????????????????????????


        //???????????????
//        AsyncExecutor asyncExecutor = AsyncExecutor.builder()
//                .eventBus(EventBus.getDefault())//??????EventBus??????
//                .failureEventType(ErrorEvent.class)//??????????????????
//                .threadPool(Executors.newCachedThreadPool())//???????????????
//                .build();


        //?????????????????????
        AsyncExecutor asyncExecutor = AsyncExecutor.builder()
//                .buildForScope(this);
                .buildForScope(new Service());


        asyncExecutor.execute(new AsyncExecutor.RunnableEx() {
            @Override
            public void run() throws Exception {
                System.out.println(Thread.currentThread());
                throw new Exception("xx");
            }
        });


    }

    public void stop(View view) {
        System.out.println("~~button.stop~~");

    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

    }

    public void reloading(View view) {
        System.out.println("~~button.reloading~~");

    }

    public void del(View view) {
        System.out.println("~~button.del~~");

    }

    public void query(View view) {
        System.out.println("~~button.query~~");

    }


    @Subscribe
    public void onFailureEvent(ThrowableFailureEvent throwableFailureEvent) {
        System.out.println("~~" + getClass().getSimpleName() + ".onFailureEvent~~");
        System.out.println("Subscribe|throwableFailureEvent = " + throwableFailureEvent);

        System.out.println("getExecutionScope is " + throwableFailureEvent.getExecutionScope());
    }

    @Subscribe
    public void onFailureEvent(ErrorEvent errorEvent) {
        System.out.println("~~" + getClass().getSimpleName() + ".onFailureEvent~~");
        System.out.println("Subscribe|errorEvent = " + errorEvent);
    }
}