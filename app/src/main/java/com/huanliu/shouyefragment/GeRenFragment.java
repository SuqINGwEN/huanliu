package com.huanliu.shouyefragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.huanliu.R;
import com.huanliu.geren.erweima.QrCodeActivity;
import com.huanliu.geren.guankanlishi.HistoryActivity;
import com.huanliu.geren.guanyu.AboutProjectActivity;
import com.huanliu.geren.shezhi.SettingActivity;
import com.huanliu.geren.tuijian.RecommendedActivity;
import com.huanliu.geren.wentifankui.FeedbackActivity;
import com.huanliu.geren.wodeshoucang.MyCollectionActivity;
import com.huanliu.geren.xiazaiguanli.DownloadManagementActivity;
import com.huanliu.geren.zhucedenglu.RegisterLoginActivity;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qzone.QZone;

/**
 * Created by Administrator on 2016/6/19 0019.
 */
public class GeRenFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button quit_btn;
    private Platform qzone;
    //已登录
    private static final int LOGIN = 0;
    //未登录
    private static final int QUIT = 1;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LOGIN:
                    quit_btn.setVisibility(View.VISIBLE);
                    break;
                case QUIT:
                    quit_btn.setVisibility(View.GONE);
                    break;
            }
        }
    };
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_geren, container, false);
        view.findViewById(R.id.fragment_geren_xiazaiguanli).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_guankanlishi).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_wodeshoucang).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_shezhi).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_erweima).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_tuijian).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_wentifankui).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_guanyu).setOnClickListener(this);

        
       //判断是否登录,如果登录显示退出按钮,并禁用登录的点击事件,显示姓名,否则隐藏
        ShareSDK.initSDK(view.getContext());
        quit_btn= (Button) view.findViewById(R.id.btn_geren_quit);
        qzone = ShareSDK.getPlatform(view.getContext(), QZone.NAME);
        if(qzone.isValid()){
           handler.sendEmptyMessage(LOGIN);
            view.findViewById(R.id.btn_geren_quit).setOnClickListener(this);
        }else{
           handler.sendEmptyMessage(QUIT);
            view.findViewById(R.id.fragment_geren_zhucedenglu).setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.fragment_geren_zhucedenglu:
                intent.setClass(view.getContext(),RegisterLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_xiazaiguanli:
                intent.setClass(view.getContext(),DownloadManagementActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_guankanlishi:
                intent.setClass(view.getContext(),HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_wodeshoucang:
                intent.setClass(view.getContext(),MyCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_shezhi:
                intent.setClass(view.getContext(),SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_erweima:
                intent.setClass(view.getContext(),QrCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_tuijian:
                intent.setClass(view.getContext(),RecommendedActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_wentifankui:
                intent.setClass(view.getContext(),FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_geren_guanyu:
                intent.setClass(view.getContext(),AboutProjectActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_geren_quit:
                qzone.removeAccount();
                handler.sendEmptyMessage(QUIT);
                Toast.makeText(view.getContext(),R.string.activity_fragment_geren_quit_success,Toast.LENGTH_SHORT).show();
                break;
        }
           
    }
}
