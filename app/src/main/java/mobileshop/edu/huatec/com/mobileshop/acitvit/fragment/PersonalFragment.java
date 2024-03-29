package mobileshop.edu.huatec.com.mobileshop.acitvit.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop.acitvit.R;
import mobileshop.edu.huatec.com.mobileshop.acitvit.activity.ChangePwdActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.activity.LoginActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.activity.MyAddressActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.activity.MyCollectActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.activity.MyOrderActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.common.BaseFragment;
import mobileshop.edu.huatec.com.mobileshop.acitvit.utils.SystemCofig;


public class PersonalFragment extends BaseFragment{

    //已登录
    @BindView(R.id.personal_for_login)
    RelativeLayout personal_for_login;
    @BindView(R.id.user_img_view)
    ImageView user_img_view;
    @BindView(R.id.user_name)
    TextView user_name;
    @BindView(R.id.user_level)
    TextView user_level;

    //未登录
    @BindView(R.id.personal_for_not_login)
    RelativeLayout personal_for_not_login;

    //退出登录
    @BindView(R.id.personal_logout_layout)
    RelativeLayout personal_logout_layout;

    @Override
    public int getContentViewId(){
        return R.layout.fragment_personal;
    }

    @Override
    protected void  initView(View view){
        super.initView(view);
        //初始状态配置
        resetUI();
    }

    private void resetUI(){
        if(SystemCofig.isLogin()){
            //已登录，显示已登录的UI，隐藏未登录的UI
            personal_for_login.setVisibility(View.VISIBLE);
            personal_for_not_login.setVisibility(View.GONE);
            personal_logout_layout.setVisibility(View.VISIBLE);

            //显示已登录的信息
            //显示头像
            ImageLoader.getInstance().displayImage(SystemCofig.getLoginUserHead(), user_img_view);
            //显示用户名
            user_name.setText(SystemCofig.getLoginUserName());
            //显示邮箱
            user_level.setText(SystemCofig.getLoginUserEmail());
        }else {
            //未登录，显示未登录的UI，隐藏已登录的UI
            personal_for_login.setVisibility(View.GONE);
            personal_for_not_login.setVisibility(View.VISIBLE);
            personal_logout_layout.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.personal_login)
    void login(){
        Intent intent= new Intent(getActivity(), LoginActivity.class);
        startActivityForResult(intent, 1000);
    }

    @OnClick(R.id.person_my_order)
    void person_my_order(){
        //我的订单
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), MyOrderActivity.class));
        }else {
            Intent intent= new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, 1001);
        }
    }

    @OnClick(R.id.my_collect)
    void my_collect(){
        //我的收藏
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), MyCollectActivity.class));
        }else {
            Intent intent= new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, 1002);
        }
    }

    @OnClick(R.id.my_address)
    void my_address(){
        //我的地址
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), MyAddressActivity.class));
        }else {
            Intent intent= new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, 1003);
        }
    }

    @OnClick(R.id.my_account)
    void my_account(){
        //修改密码
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), ChangePwdActivity.class));
        }else {
            Intent intent= new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, 1004);
        }
    }

    @OnClick(R.id.personal_logout_layout)
    void logout(){
        //退出登录
        SystemCofig.logout();
        resetUI();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            //重置UI
            resetUI();

            //打开登录之前想要进入的页面
            Intent intent = new Intent();
            if (requestCode == 1000){

            }else if (requestCode == 1001){
                intent.setClass(getActivity(), MyOrderActivity.class);
                startActivity(intent);
            }else if (requestCode == 1002){
                intent.setClass(getActivity(), MyCollectActivity.class);
                startActivity(intent);
            }else if (requestCode == 1003){
                intent.setClass(getActivity(), MyAddressActivity.class);
                startActivity(intent);
            }else if (requestCode == 1004){
                intent.setClass(getActivity(), ChangePwdActivity.class);
                startActivity(intent);
            }
        }
    }

}
