package com.android.golauncher.golauncherfonts;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GOLauncherFontsActivity extends Activity {
    public static int fontCount = 1;
    public static ArrayList<Font> mFonts = new ArrayList<Font>();
    public static FontAdapter madapter;
    public static final String LOG_TAG = "beecub";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @SuppressWarnings("static-access")
    public void onResume() {
        super.onResume();
        
        mFonts = new ArrayList<Font>();
        this.madapter = new FontAdapter(this, R.layout.row_preview, mFonts);
        //madapter.notifyDataSetChanged();
        
        ListView lv = (ListView) findViewById(R.id.prieviewList);
        lv.setAdapter(madapter);
        
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               if(v != null) {
                   v.inflate(getBaseContext(), R.layout.row_preview, parent);
               }
            }
        });
        
        /*******************************************/
        for(int i = 1; i <= fontCount; i++) {
            madapter.add(new Font(getString(R.string.f1_name), getString(R.string.f1_name), getString(R.string.f1_name)));
        }
        /*******************************************/
    }
    
    public class FontAdapter extends ArrayAdapter<Font> {
        
        private ArrayList<Font> items;

        public FontAdapter(Context context, int textViewResourceId, ArrayList<Font> items) {
                super(context, textViewResourceId, items);
                this.items = items;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row_preview, null);
            }
            Font o = items.get(position);
            if (o != null) {
                TextView tv1 = (TextView) v.findViewById(R.id.name);
                TextView tv2 = (TextView) v.findViewById(R.id.license);
                TextView tv3 = (TextView) v.findViewById(R.id.author);
                
                if(tv1 != null) {
                    tv1.setText(o.getName());
                }
                if(tv2 != null) {
                    tv2.setText(o.getLicense());
                }
                if(tv3 != null) {
                    tv3.setText(o.getAuthor());
                }
            }
            return v;
        }
    }
}
