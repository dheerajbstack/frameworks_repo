package app.ssl.sslapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Build;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.view1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        //String url = "https://cacert.org/";
        //String url = "https://www.websocket.org/echo.html";
        String url = "https://www.ip-api.com/json";
        //webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        //String url = "http://self-signed.badssl.com";
    }

}
