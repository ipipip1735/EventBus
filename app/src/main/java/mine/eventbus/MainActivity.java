package mine.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import mine.eventbus.events.TheEvent;

/**
 * Created by Administrator on 2021/3/3.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
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



        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread());
            EventBus.getDefault().post(new TheEvent(i));
        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println(Thread.currentThread());
//                    EventBus.getDefault().post(new TheEvent(i));
////                    EventBus.getDefault().post(new TheEvent(i));
//                }
//            }
//        }).start();

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


    @Subscribe(threadMode = ThreadMode.ASYNC)
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    @Subscribe(threadMode = ThreadMode.POSTING)
//    @Subscribe
    public void onMessageEvent(TheEvent event) {
        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEvent~~");
        System.out.println("event = " + event);

        System.out.println(Thread.currentThread());

        if(event.age == 1) EventBus.getDefault().post(new TheEvent(11));

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




////    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
//    @Subscribe(threadMode = ThreadMode.MAIN)
////    @Subscribe(threadMode = ThreadMode.POSTING)
////    @Subscribe
//    public void onMsg(TheEvent event) {
//        System.out.println("~~" + getClass().getSimpleName() + ".onMsg~~");
//        System.out.println("event = " + event);
//        System.out.println(Thread.currentThread());
//    }

}