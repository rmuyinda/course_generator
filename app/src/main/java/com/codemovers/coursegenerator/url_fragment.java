package com.codemovers.coursegenerator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;



public class url_fragment extends Fragment {
    String mURL = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("DetailFragment", "onCreate()");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("DetailFragment", "onActivityCreated()");
        if (savedInstanceState != null) {
            mURL = savedInstanceState.getString("currentURL", "");
        }
        if(!mURL.trim().equalsIgnoreCase("")){
            WebView myWebView = (WebView) getView().findViewById(R.id.webView);
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.setWebViewClient(new MyWebViewClient());
            myWebView.loadUrl(mURL.trim());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentURL", mURL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("DetailFragment", "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_url_fragment, container, false);
        return view;
    }

    public void setURLContent(String URL) {
        mURL = URL;
    }

    public void updateURLContent(String URL) {
        mURL = URL;
        WebView myWebView = (WebView) getView().findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl(mURL.trim());
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }


}
