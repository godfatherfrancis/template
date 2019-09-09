package info.highresfelix.browserandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * created by @highresfelix on 2019-09-07
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button backButton;
    Button forwardButton;
    EditText addressBar;
    Button goButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backButton = (Button) findViewById(R.id.backbutton);
        forwardButton = (Button) findViewById(R.id.forwardbutton);
        addressBar = (EditText) findViewById(R.id.addressBar);
        goButton = (Button) findViewById(R.id.gobutton);
        webView = (WebView) findViewById(R.id.webView);

        backButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                addressBar.setText(url);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == backButton) {
            webView.goBack();
        } else if (view == forwardButton) {
            webView.goForward();
        } else if (view == goButton) {
            String address = addressBar.getText().toString();
            if (!address.startsWith("http")) {
                address = "http://" + address;
            }
            webView.loadUrl(address);
        }
    }
}
