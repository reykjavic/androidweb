package edu.facemash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String file = "file:///android_asset/www/index.html";

        WebView view = (WebView) this.findViewById(R.id.webView1);

        WebSettings settings = view.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);

        settings.setBuiltInZoomControls(true);

        view.requestFocusFromTouch();

        view.setWebViewClient(new WebViewClient());
        view.setWebChromeClient(new WebChromeClient());

        view.addJavascriptInterface(new WebAppInterface(this), "android");
        view.loadUrl(file);
    }
}
