package edu.facemash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import edu.facemash.SQLite.Database;

public class MainActivity extends AppCompatActivity {

    WebView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view = (WebView) this.findViewById(R.id.webView1);

        WebSettings settings = view.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBuiltInZoomControls(true);

        view.requestFocusFromTouch();
        view.setWebViewClient(new WebViewClient());
        view.setWebChromeClient(new WebChromeClient());
        view.addJavascriptInterface(new WebAppInterface(this), "android");
    }

    @Override
    protected void onStart() {
        super.onStart();
        String baseUrl = "file:///android_asset/www/index.html";
        Database db = new Database(this);

//        view.loadDataWithBaseURL(baseUrl, db.getWorkers(), "text/html", "UTF-8", null);
        view.loadUrl(baseUrl, null);
    }
}
