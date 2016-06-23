package com.huanliu.geren.xiazaiguanli.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huanliu.R;

/**
 * Created by Administrator on 2016/6/20 0020.
 */
public class BendiShipinFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_download_management_fragment_bendishipin,container,false);
        return view;
    }
}
