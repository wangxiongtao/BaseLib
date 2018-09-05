package com.dawn.baselib;

import com.dawn.baselib.util.LogUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class q {

    public static void main(String[] args) {
//        r();
//        r();
//        Observable.just("");
        Map<String,String>map=new HashMap<>();
        map.put("a","234");
        map.put("a","4567888");
        System.out.println("map=="+map);

    }

    public static void r() {

        new ObservableCreate<>(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

//                e.onNext("send data");

            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).startWith("startwith").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                System.out.println("=====onNext====>" + value);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static void merger(){


        Observable<String> observable1=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Thread.sleep(3000);
                e.onNext("one");
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<String> observable2=Observable.just("two");


        Observable.merge(observable1,observable2)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        System.out.println("=====onNext====>" + value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
