package mine.eventbus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import mine.eventbus.events.OneEvent;
import mine.eventbus.events.TheEvent;

/**
 * Created by Administrator on 2021/3/4.
 */
public class StickyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EventBus.getDefault().register(this);
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
//                    EventBus.getDefault().post(new TheEvent(i));//发送普通事件
                    EventBus.getDefault().postSticky(new TheEvent(i));//发送粘性事件
                }
            }
        }).start();

    }

    public void stop(View view) {
        System.out.println("~~button.stop~~");
        EventBus.getDefault().register(this);
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


//    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)//sticky默认为false
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TheEvent event) {
        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEvent~~");
        System.out.println("Subscribe|event = " + event);//获取事件

        TheEvent e = EventBus.getDefault().getStickyEvent(TheEvent.class);//获取粘性事件
        System.out.println("Subscribe|stickyEvent is " + e);

        System.out.println(event.equals(e));//粘性事件和接收的事件是同一个对象

        //手动删除粘性事件
//        System.out.println(event.equals(e));
//        if (e != null) {
//            EventBus.getDefault().removeStickyEvent(e);
//        }


    }


}