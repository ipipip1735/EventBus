package mine.eventbus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import mine.eventbus.events.TheEvent;

/**
 * Created by Administrator on 2021/3/7.
 */
public class PrioritiesActivity extends AppCompatActivity {

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    EventBus.getDefault().post(new TheEvent(i));
                }
            }
        }).start();

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


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventOne(TheEvent event) {
        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEventOne~~");
        System.out.println("Subscribe|event = " + event);//????????????
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEventTwo(TheEvent event) {
        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEventTwo~~");
        System.out.println("Subscribe|event = " + event);//????????????

        if(event.age == 0){
            System.out.println("cancel!");
            EventBus.getDefault().cancelEventDelivery(event);
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}