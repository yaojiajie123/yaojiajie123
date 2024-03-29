package mobileshop.edu.huatec.com.mobileshop.acitvit.http.service;

import java.util.List;


import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.GoodsDetailEntity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.GoodsEntity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.HttpResult;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface GoodsService {

    @GET("goods/union/{goodsId}")
    Observable<HttpResult<GoodsDetailEntity>> goodsDetail(
            @Path("goodsId") int goodsId
    );

    @FormUrlEncoded
    @POST("goods/find")
    Observable<HttpResult<List<GoodsEntity>>> listByKeywords(
            @Field("input") String keywords
    );

    @GET("goods/cat/{catId}")
    Observable<HttpResult<List<GoodsEntity>>> list(
            @Path("catId") int catId
    );
}
