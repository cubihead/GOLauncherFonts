package com.beecub.golauncher.golauncherfonts;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class DetailedPreviewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        TextView tv4 = (TextView) findViewById(R.id.textView4);
        TextView tv5 = (TextView) findViewById(R.id.textView5);
        
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String author = b.getString("author");
        String license = b.getString("license");
        String link = b.getString("link");
        String typeface = b.getString("typeface");
        
        
        if(tv1 != null) {
            tv1.setText(name);
            tv1.setTypeface(Typeface.createFromAsset(getAssets(), typeface));
        }
        if(tv2 != null) {
            tv2.setText(Html.fromHtml(getString(R.string.author) + ": " + "<a href=\"" + link + "\">" + author + "</a>"));
            tv2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if(tv3 != null) {
            tv3.setText(getString(R.string.license) + ": " + license);
        }
        if(tv4 != null) {
            tv4.setText(getString(R.string.preview)+ ": ");
        }
        if(tv5 != null) {
            tv5.setText(getString(R.string.demo));
            tv5.setTypeface(Typeface.createFromAsset(getAssets(), typeface));
        }
        
    }

}
