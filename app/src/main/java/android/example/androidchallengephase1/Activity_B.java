package android.example.androidchallengephase1;

import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activity_B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__b);

        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.loadUrl("https://andela.com/alc/");

        mywebview.setWebViewClient(new IgnoreSSl());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }



    private class IgnoreSSl extends WebViewClient
    {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }
}
