package com.example.myapplicationlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

public class Main3Activity extends AppCompatActivity {
    private TextView tvResultContinue;
    private AMapLocationClient locationClientSingle = null;
    private AMapLocationClient locationClientContinue = null;
    String s;
    String m;
    String []n;
    private SharedPreferences pres;
    private SharedPreferences.Editor editor;

    private int continueCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        pres=getSharedPreferences("crazyii", Context.MODE_PRIVATE);
        editor=pres.edit();
        tvResultContinue = (TextView)findViewById(R.id.text2);
        startContinueLocation();
        tvResultContinue.setText("正在定位...");
        continueCount = 0;

    }
    void startContinueLocation(){
        if(null == locationClientContinue){
            locationClientContinue = new AMapLocationClient(this.getApplicationContext());
        }

        //使用连续的定位方式  默认连续
        AMapLocationClientOption locationClientOption = new AMapLocationClientOption();
        // 地址信息
        locationClientOption.setGpsFirst(true);
        locationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        locationClientOption.setNeedAddress(true);
        locationClientContinue.setLocationOption(locationClientOption);
        locationClientContinue.setLocationListener(locationContinueListener);
        locationClientContinue.startLocation();
    }
    AMapLocationListener locationContinueListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation location) {
            continueCount ++;
            long callBackTime = System.currentTimeMillis();
            StringBuffer sb = new StringBuffer();
            sb.append("持续定位完成 " + continueCount +  "\n");
            sb.append("回调时间: " + Utils.formatUTC(callBackTime, null) + "\n");
            if(null == location){
                sb.append("定位失败：location is null!!!!!!!");
            } else {
                n=Utils.getLocationStr(location);
                sb.append(n[0].trim());
            }

            tvResultContinue.setText(sb.toString());
            s=n[0].trim();
            m=n[1];
            editor.putString("message", s);
            editor.putString("city",m);
            editor.apply();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != locationClientSingle){
            locationClientSingle.onDestroy();
            locationClientSingle = null;
        }
        if(null != locationClientContinue){
            locationClientContinue.onDestroy();
            locationClientContinue = null;
        }
    }
    void stopContinueLocation(){
        if(null != locationClientContinue){
            locationClientContinue.stopLocation();
        }
    }
}
