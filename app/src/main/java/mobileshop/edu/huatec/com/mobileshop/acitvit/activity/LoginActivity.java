package mobileshop.edu.huatec.com.mobileshop.acitvit.activity;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop.acitvit.R;
import mobileshop.edu.huatec.com.mobileshop.acitvit.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.ProgressDialogSubscriber;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.entity.MemberEntity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.http.presenter.MemberPresenter;
import mobileshop.edu.huatec.com.mobileshop.acitvit.utils.SystemCofig;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @Override
    public int getContentViewId(){
        return R.layout.activity_login;
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
    @OnClick(R.id.bt_login)
    void login(){
        String userName = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName)){
            toastShort("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            toastShort("请输入密码");
            return;
        }
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this){

            @Override
            public void onNext(MemberEntity memberEntity) {
                //保存登录状态0
                SystemCofig.setLogin(true);
                //弹出登录成功提示
                toastShort("登录成功");
                //保存登录账户的信息
                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);
                //返回数据，只有调用了setResult, 在调用的地方才会回调onActivityResult方法
                setResult(RESULT_OK);
                finish();
            }

        },userName, pwd);
    }
}
