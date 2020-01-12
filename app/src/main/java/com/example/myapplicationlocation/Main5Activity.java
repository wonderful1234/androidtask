package com.example.myapplicationlocation;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    private static List<String> sNeedPermissions=new ArrayList<>();

    private PermissionUtils permissionUtils= null;

//静态块中初始化所需要的权限
static {
        sNeedPermissions.add(Manifest.permission.SEND_SMS);
        sNeedPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        sNeedPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        sNeedPermissions.add(Manifest.permission.INTERNET);
        sNeedPermissions.add(Manifest.permission.READ_PHONE_STATE);
        sNeedPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

@RequiresApi(api = Build.VERSION_CODES.M)
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        permissionUtils=new PermissionUtils(this);

        permissionUtils.request(sNeedPermissions, 100, new PermissionUtils.CallBack() {
@Override
public void grantAll() {
        toMainActivity();
        finish();
        }

@Override
public void denied() {
        fileList();
        }
        });

        }


public void toMainActivity(){
        //进入主Activity
        startActivity(new Intent(Main5Activity.this,MainActivity.class));
        }

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionUtils.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
        }
