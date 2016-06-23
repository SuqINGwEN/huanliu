package com.huanliu.shouyefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by Administrator on 2016/6/19 0019.
 */
public class GeRenFragment extends Fragment implements View.OnClickListener {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_geren, container, false);
        
        view.findViewById(R.id.fragment_geren_zhucedenglu).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_xiazaiguanli).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_guankanlishi).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_wodeshoucang).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_shezhi).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_erweima).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_tuijian).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_wentifankui).setOnClickListener(this);
        view.findViewById(R.id.fragment_geren_guanyu).setOnClickListener(this);
        
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
        }
            
    }
}
