package com.example.myapplication.utils;

import android.app.Application;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.services.core.ServiceSettings;
import com.example.basic.BaseApplication;
import com.example.basic.BuildConfig;
import com.example.basic.router.ARouter;

public class MyApplication extends Application {
//    private static boolean isApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        //定位隐私政策同意
        AMapLocationClient.updatePrivacyShow(this,true,true);
        AMapLocationClient.updatePrivacyAgree(this,true);
        //地图隐私政策同意
        MapsInitializer.updatePrivacyShow(this,true,true);
        MapsInitializer.updatePrivacyAgree(this,true);
        //搜索隐私政策同意
        ServiceSettings.updatePrivacyShow(this,true,true);
        ServiceSettings.updatePrivacyAgree(this,true);
//        isApplication = BuildConfig.isApplication;
//        ARouter.getInstance().init(this);
    }
}
