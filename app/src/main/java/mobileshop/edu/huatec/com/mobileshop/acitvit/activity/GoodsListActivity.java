package mobileshop.edu.huatec.com.mobileshop.acitvit.activity;

import android.content.Intent;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop.acitvit.R;
import mobileshop.edu.huatec.com.mobileshop.acitvit.adapter.GoodsListAdapter;
import mobileshop.edu.huatec.com.mobileshop.acitvit.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.GoodsEntity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.presenter.GoodsPresenter;
import rx.Subscriber;

public class GoodsListActivity extends BaseActivity {

    private int cat_id;

    @BindView(R.id.goodslist_swipe_refresh)
    SwipeRefreshLayout goodslistSwipeRefresh;
    @BindView(R.id.goodslist_recycleview)
    RecyclerView goodslistRecycleview;
    @BindView(R.id.goodslist_nodata)
    TextView goodsListNoData;

    private List<GoodsEntity> listData;
    private GoodsListAdapter adapter;

    @Override
    public int getContentViewId(){
        return R.layout.activity_goodslist;
    }

    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }

    @Override
    protected void initView(){
        super.initView();
        goodsListNoData.setVisibility(View.GONE);

        cat_id = getIntent().getIntExtra("cat_id", 0);

        goodslistSwipeRefresh.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        goodslistSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        goodslistRecycleview.setLayoutManager(layoutManager);

        listData = new ArrayList<GoodsEntity>();
        adapter = new GoodsListAdapter(this, listData);
        adapter.setOnItemClickListener(new GoodsListAdapter.OnItemClickListener(){
           @Override
           public void onItemClick(View view, int position, GoodsEntity entity){

               Intent intent = new Intent(GoodsListActivity.this,GoodsListActivity.class);
               intent.putExtra("goods_id", entity.getGoods_id());
               intent.putExtra("goods_name", entity.getName());
               startActivity(intent);
           }
        });
        goodslistRecycleview.setAdapter(adapter);
    }

    @Override
    protected void initData(){
        super.initData();
        loadData();
    }

    private void loadData(){
        GoodsPresenter.list(new Subscriber<List<GoodsEntity>>() {
            @Override
            public void onCompleted() {
                goodslistSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                goodslistSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onNext(List<GoodsEntity> goodsEntities) {
                listData.clear();
                listData.addAll(goodsEntities);
                adapter.notifyDataSetChanged();

                if (listData == null || listData.size() == 0){
                    toastShort("没有该列表的商品数据！");
                    goodsListNoData.setVisibility(View.VISIBLE);
                    goodslistRecycleview.setVisibility(View.GONE);
                }else {
                    goodsListNoData.setVisibility(View.GONE);
                    goodslistRecycleview.setVisibility(View.VISIBLE);
                }
            }
        },cat_id);
    }
}
