package mine.eventbus.bus;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.PublishProcessor;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Administrator on 2021/3/8.
 */
public class RxBus {

    private static RxBus rxBus;
    private FlowableProcessor flowableProcessor;

    private RxBus() {
        flowableProcessor = PublishProcessor.create();
//        flowableProcessor = PublishProcessor.create().toSerialized();
    }


    public static RxBus getInstance() {
        if (rxBus == null) {
            rxBus = new RxBus();
        }

        return rxBus;
    }


    public void post(Object event) {

        if (rxBus.flowableProcessor.hasSubscribers()) {
            rxBus.flowableProcessor.onNext(event);
        }
    }

    public <T> Disposable subscribe(Class<T> type,
                                    @NonNull Consumer<? super T> onNext,
                                    @NonNull Consumer<? super Throwable> onError) {

        return rxBus.flowableProcessor
                .ofType(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }

}
