package mine.eventbus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.SubscriberExceptionEvent;
import org.greenrobot.eventbus.ThreadMode;

import mine.eventbus.events.TheEvent;

/**
 * Created by Administrator on 2021/3/4.
 */
public class ConfigActivity extends AppCompatActivity {

    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //构建新实例
//        eventBus = EventBus.builder()
////                .logNoSubscriberMessages(false)
////                .sendNoSubscriberEvent(true)
////                .throwSubscriberException(true)
//                .build();
//        eventBus.register(this);

        //构建默认单例
//        EventBus.builder()
//                .throwSubscriberException(BuildConfig.DEBUG)
//                .installDefaultEventBus()
//                .register(this);

        //默认注册器
        EventBus.builder()
                .logNoSubscriberMessages(BuildConfig.DEBUG)
                .sendNoSubscriberEvent(BuildConfig.DEBUG)
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
//        eventBus.post(new TheEvent());

        EventBus.getDefault().post(new TheEvent());
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
    public void onMessageEvent(NoSubscriberEvent noSubscriberEvent) {
        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEvent~~");
        System.out.println("noSubscriberEvent = " + noSubscriberEvent);
    }


//    @Subscribe
//    public void onMessageEvent(SubscriberExceptionEvent subscriberExceptionEvent) {
//        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEvent~~");
//        System.out.println("subscriberExceptionEvent = " + subscriberExceptionEvent);
//    }


//    @Subscribe
//    public void onMessageEvent(TheEvent event) {
//        System.out.println("~~" + getClass().getSimpleName() + ".onMessageEvent~~");
//        System.out.println("event = " + event);
//
////        int i = 3 / 0;
//    }


}