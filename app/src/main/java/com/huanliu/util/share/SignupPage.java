package com.huanliu.util.share;

import com.mob.tools.FakeActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Administrator on 2016/6/21 0021.
 */
public class SignupPage extends FakeActivity {
    private Platform platform;
    private HashMap<String,Object> userData;
    
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setUserData(HashMap<String, Object> userData) {
        this.userData = userData;
    }

    public void setPlatform(String platName) {
        platform = ShareSDK.getPlatform(platName);
    }
}
