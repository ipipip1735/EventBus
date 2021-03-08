package mine.eventbus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.PublishProcessor;
import mine.eventbus.bus.RxBus;
import mine.eventbus.events.RxEvent;

/**
 * Created by Administrator on 2021/3/8.
 */
public class RxJavaActivity extends AppCompatActivity {

    private FlowableProcessor flowableProcessor;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        flowableProcessor = PublishProcessor.create();
//        flowableProcessor = PublishProcessor.create().toSerialized();//线程安全

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

        compositeDisposable.dispose();

        super.onDestroy();
    }


    public void start(View view) {
        System.out.println("~~button.start~~");


        //方式一
//        Disposable disposable = flowableProcessor
//                .ofType(RxEvent.class)
//                .onBackpressureLatest()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(System.out::println);
//        compositeDisposable.add(disposable);


        //方式二
        Disposable disposable = RxBus.getInstance()
                .subscribe(RxEvent.class, System.out::println, Throwable::printStackTrace);
        compositeDisposable.add(disposable);


        //粘性事件
//        RxEvent rxEvent = new RxEvent();
//
//        synchronized (this) {
//            mStickyEventMap.put(rxEvent.getClass(), rxEvent);
//        }
//
//        if (flowable.hasSubscribers()) {
//            flowable.onNext(rxEvent);
//        }


    }

    public void stop(View view) {
        System.out.println("~~button.stop~~");

        //方式一
//        if (flowableProcessor.hasSubscribers()) {
//            Flowable.range(1, 5)
//                    .map(integer -> new RxEvent(integer))
//                    .subscribe(flowableProcessor);
//        }

        //方式二
        for (int i = 0; i < 5; i++) {
            RxBus.getInstance().post(new RxEvent(i));
        }

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
}