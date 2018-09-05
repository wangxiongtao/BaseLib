package com.dawn.baselib.util;


import android.os.Handler;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018/4/4 0004.
 */

public class CountDowntimerUtil {
    private static Disposable disposable;


    public static void countDown(final int time, final OnCountDownListener listener) {

        if(disposable!=null&&!disposable.isDisposed()){
            return;
        }

        Observable.interval(1, TimeUnit.SECONDS).take(time + 1)
                .map(new Function<Long, Long>() {

                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time - aLong;
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {

            }
        }).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                LogUtil.i("==onNext====>"+aLong);
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                LogUtil.i("==doOnComplete====>");
            }
        });

    }

    public static void destory(){
        if(disposable!=null&&!disposable.isDisposed()){
            disposable.dispose();
        }
    }
    public interface OnCountDownListener{
        void onCountDown(long time);
    }

}
