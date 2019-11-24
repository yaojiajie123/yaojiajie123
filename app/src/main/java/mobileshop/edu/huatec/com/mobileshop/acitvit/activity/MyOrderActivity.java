package mobileshop.edu.huatec.com.mobileshop.acitvit.activity;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop.acitvit.R;
import mobileshop.edu.huatec.com.mobileshop.acitvit.common.BaseActivity;

public class MyOrderActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId(){return R.layout.activity_my_order;}

    @Override
    protected void initView(){
        super.initView();
        tvTitle.setText("我的订单");
    }

    @OnClick(R.id.iv_back)
    void close(){finish();}

}
