package mobileshop.edu.huatec.com.mobileshop.acitvit.http.presenter;

import org.w3c.dom.Entity;

import java.util.List;


import mobileshop.edu.huatec.com.mobileshop.acitvit.http.HttpMethods;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.ProgressDialogSubscriber;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.GoodsDetailEntity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.GoodsEntity;

import rx.Observable;
import rx.Subscriber;


public class GoodsPresenter extends HttpMethods {

    public static void goodsDetail(ProgressDialogSubscriber<GoodsDetailEntity> subscriber, int goodsId){
        Observable<GoodsDetailEntity> observable = goodsService.goodsDetail(goodsId)
                .map(new HttpResultFunc<GoodsDetailEntity>());
        toSubscribe(observable, subscriber);
    }

    public static void listByKeywords(Subscriber<List<GoodsEntity>> subscriber, String keywords){
        Observable<List<GoodsEntity>> observable = goodsService.listByKeywords(keywords)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable, subscriber);
    }

    public static void list(Subscriber<List<GoodsEntity>> subscriber, int catId){
        Observable<List<GoodsEntity>> observable = goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable, subscriber);
    }
}
