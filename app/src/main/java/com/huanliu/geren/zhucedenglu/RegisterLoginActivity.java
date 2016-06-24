package com.huanliu.geren.zhucedenglu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.huanliu.R;
import com.huanliu.shouyefragment.GeRenFragment;
import com.huanliu.util.share.SignupPage;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;

public class RegisterLoginActivity extends Activity
        implements Handler.Callback, View.OnClickListener, PlatformActionListener {
    private TextView textView;

    private Handler handler;

    private static final int MSG_SMSSDK_CALLBACK = 1;
    private static final int MSG_AUTH_CANCEL = 2;
    private static final int MSG_AUTH_ERROR= 3;
    private static final int MSG_AUTH_COMPLETE = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register_login);
        ShareSDK.initSDK(this);
        title();
    }

    private void title() {
        textView = (TextView) findViewById(R.id.geren_back_tital_textview);
        textView.setText(R.string.activity_fragment_geren_zhucedenglu);

        findViewById(R.id.qQlogin).setOnClickListener(this);
        findViewById(R.id.sinaWbLogin).setOnClickListener(this);

        
        
        handler = new Handler(this);
    }

    Platform qzon = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qQlogin:
                //qq平台
                qzon = ShareSDK.getPlatform(QZone.NAME);
                authorize(qzon);
                break;
            case R.id.sinaWbLogin:
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                authorize(weibo);
                break;
        }
    }

    private void authorize(Platform plat) {
        if (plat == null) {
            return;
        }
        plat.setPlatformActionListener(this);
        //sso授权
        plat.SSOSetting(true);
        //显示用户信息
        plat.showUser(null);
    }


    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case MSG_AUTH_CANCEL:
                Toast.makeText(this,"授权已取消",Toast.LENGTH_SHORT).show();
                break;
            case MSG_AUTH_ERROR:
                Toast.makeText(this,"授权失败",Toast.LENGTH_SHORT).show();
                break;
            case MSG_AUTH_COMPLETE:
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                Object[] res= (Object[]) msg.obj;
                String platName= (String) res[0];
//                HashMap<String,Object> userData= (HashMap<String, Object>) res[1];
                SignupPage signupPage=new SignupPage();
                signupPage.setPlatform(platName);
                Intent intent=new Intent(this,GeRenFragment.class);
                startActivity(intent);
                break;
        }
        return false;
    }


    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> map) {
        if (action == Platform.ACTION_USER_INFOR) {
            Message msg=new Message();
            msg.what=MSG_AUTH_COMPLETE;
            msg.obj=new Object[]{platform.getName(),map};
            handler.sendMessage(msg);
        }
    }

    @Override
    public void onError(Platform platform, int action, Throwable t) {
        if (action == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_ERROR);
        }
        t.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int action) {
        if (action == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_CANCEL);
        }
    }
}
