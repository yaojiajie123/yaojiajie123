/*package mobileshop.edu.huatec.com.mobileshop.acitvit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import java.util.jar.Attributes;

public class MyWebView extends WebView {
    private IWebViewScroll mIWebViewScroll;

    public MyWebView(Context context){super(context,null);}

    public MyWebView(Context context, Attributes attrs){super(context, (AttributeSet) attrs,0);}

    public MyWebView(Context context,Attributes attrs,int defStyleAttr){
        super(context, (AttributeSet) attrs,defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l,int t,int oldl,int oldt){
        super.onScrollChanged(l,t,oldl,oldt);
        if (mIWebViewScroll !=null && t==0){
            mIWebViewScroll.onTop();
        }else if (mIWebViewScroll !=null && t!=0){
            mIWebViewScroll.notOnTop();
        }
    }

    public void setOnCustomScrollChanged(IWebViewScroll listener){
        this.mIWebViewScroll = listener;
    }

    public interface IWebViewScroll{
        void onTop();

        void notOnTop();
    }
}
*/