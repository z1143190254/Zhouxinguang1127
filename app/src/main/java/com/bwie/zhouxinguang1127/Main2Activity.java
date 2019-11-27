package com.bwie.zhouxinguang1127;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button_ku;
    private WebView web;
    String url = "file:///android_asset/info.html";
    private EditText editText;
    private String trim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        button_ku = (Button) findViewById(R.id.button_ku);
        web = (WebView) findViewById(R.id.web);
        editText = findViewById(R.id.edit_gai);

        button_ku.setOnClickListener(this);

        web.loadUrl(url);
        web.addJavascriptInterface(new JsDemo(), "android");
        WebSettings settings = web.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_ku:
                trim = editText.getText().toString().trim();
                if (trim.isEmpty()) {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    web.loadUrl("javascript: changeNum(" + trim + ")");
                    break;
                }
        }
    }

    class JsDemo {
        @JavascriptInterface
        public void buyNow() {
            Log.i("xxx", trim);
        }
    }
}
