package com.baiduocrstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baiduocrstudy.R;

public class MainActivity extends AppCompatActivity {

    private MainActivity selfActivity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAccessToken();
    }

    private void initAccessToken() {
        OCR.getInstance().initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token=accessToken.getAccessToken();
            }

            @Override
            public void onError(OCRError ocrError) {
                ocrError.printStackTrace();
                Toast.makeText(selfActivity, "licence方式获取token失败", Toast.LENGTH_SHORT).show();
            }
        }, selfActivity);
    }

    public void startOcr(View view) {
        startActivity(new Intent(MainActivity.this, IDCardActivity.class));
        finish();
    }

}
