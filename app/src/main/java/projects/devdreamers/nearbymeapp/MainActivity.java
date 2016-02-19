package projects.devdreamers.nearbymeapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

//http://stackoverflow.com/a/9173368 Dialog webView
public class MainActivity extends AppCompatActivity {

    WebView web;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //http://stackoverflow.com/a/9173368
//                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
//                alert.setTitle("Login ");
//
//
//                WebView wv = new WebView(MainActivity.this);
//                wv.getSettings().setJavaScriptEnabled(true);
//                wv.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=451613e5b7f54db4820b4ddf6fc66a74&redirect_uri=http://www.shareapp.com.mx&response_type=token");
//                wv.setWebViewClient(new WebViewClient() {
//                    @Override
//                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//                        view.loadUrl(url);
//
//                        view.getSettings().setJavaScriptEnabled(true);
//                        view.requestFocus(View.FOCUS_DOWN);
//
//                        return true;
//                    }
//                });
//
//                alert.setView(wv);
//                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                    }
//                });
//
//                alert.show();
                //Hide Title Bar	- This Should be done before SetContentView

//                MainActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//                setContentView(R.layout.activity_main);
                // Inflation

                web = (WebView) findViewById(R.id.webView);
                web.setWebViewClient(new WebViewClient() {

                    public boolean onConsoleMessage(ConsoleMessage cmsg)
                    {
                        /* process JSON */
                        Log.e("JLCS",cmsg.toString());
                        cmsg.message();
                        return true;

                    }
                    // This method will be triggered when the Page Started Loading

                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        dialog = ProgressDialog.show(MainActivity.this, null,
                                "Please Wait...Page is Loading...");
                        dialog.setCancelable(true);
                        super.onPageStarted(view, url, favicon);
                    }

                    // This method will be triggered when the Page loading is completed

                    public void onPageFinished(WebView view, String url) {
                        dialog.dismiss();

                        super.onPageFinished(view, url);
                    }

                    // This method will be triggered when error page appear

                    public void onReceivedError(WebView view, WebResourceRequest wrr, WebResourceError wre) {
                        dialog.dismiss();
                        Log.e("JLCS",wrr.toString());
                        Log.i("JLCS",wre.toString());
                        // You can redirect to your own page instead getting the default
                        // error page
                        Toast.makeText(MainActivity.this,
                                "The Requested Page Does Not Exist", Toast.LENGTH_LONG).show();
                        //web.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=451613e5b7f54db4820b4ddf6fc66a74&redirect_uri=http://www.shareapp.com.mx&response_type=token");
                        super.onReceivedError(view, wrr, wre);
                    }
                });

                web.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=451613e5b7f54db4820b4ddf6fc66a74&redirect_uri=http://localhost/&response_type=token");
                Log.d("TOKEN", web.getUrl().toString());
                web.getSettings().setJavaScriptEnabled(true);
                web.getSettings().setLoadWithOverviewMode(true);
                web.getSettings().setUseWideViewPort(true);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
