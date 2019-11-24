package mobileshop.edu.huatec.com.mobileshop.acitvit.activity;

import android.app.FragmentManager;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import mobileshop.edu.huatec.com.mobileshop.acitvit.R;
import mobileshop.edu.huatec.com.mobileshop.acitvit.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop.acitvit.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {

    @Override
    public @LayoutRes
    int getContentViewId(){
        return R.layout.activity_main;
    }

    @Override
    protected void initView(){
        super.initView();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.f1_main,new NavigationFragment());
        transaction.commit();




    }
}
