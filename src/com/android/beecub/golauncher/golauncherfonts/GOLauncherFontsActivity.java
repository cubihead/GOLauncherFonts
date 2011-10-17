package com.android.beecub.golauncher.golauncherfonts;

import java.util.ArrayList;

import com.android.golauncher.golauncherfonts.R;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GOLauncherFontsActivity extends Activity {
    public static ArrayList<Font> mFonts = new ArrayList<Font>();
    public static FontAdapter madapter;
    public static final String LOG_TAG = "beecub";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.v(LOG_TAG, "0");
    }
    
    @SuppressWarnings("static-access")
    public void onResume() {
        super.onResume();
        
        mFonts = new ArrayList<Font>();
        this.madapter = new FontAdapter(this, R.layout.row_preview, mFonts);
        //madapter.notifyDataSetChanged();
        
        ListView lv = (ListView) findViewById(R.id.prieviewList);
        lv.setAdapter(madapter);
        
//        lv.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//               if(v != null) {
//                   v.inflate(getBaseContext(), R.layout.row_preview, parent);
//               }
//            }
//        });
        
        TextView tv1 = (TextView) findViewById(R.id.preview);
        tv1.setText(getString(R.string.preview));
        TextView tv2 = (TextView) findViewById(R.id.instructions);
        tv2.setText(getString(R.string.instruction));
        
        
        // 1 = Name
        // 2 = License
        // 3 = Author
        // 4 = URL
        // 5 = Category
        
        Resources res = getResources();
        String[] fonts = res.getStringArray(R.array.fonts);
        
        int i = 5;
        while(i < fonts.length) {
            madapter.add(new Font(fonts[i], fonts[i+1], fonts[i+2], Typeface.createFromAsset(getAssets(), "fonts/" + fonts[i] + ".ttf")));
            i = i + 5;
        }
        
        
        // fonts
        //madapter.add(new Font(getString(R.string.f0_name), getString(R.string.f0_license), getString(R.string.f0_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f0_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f1_name), getString(R.string.f1_license), getString(R.string.f1_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f1_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f2_name), getString(R.string.f2_license), getString(R.string.f2_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f2_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f3_name), getString(R.string.f3_license), getString(R.string.f3_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f3_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f4_name), getString(R.string.f4_license), getString(R.string.f4_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f4_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f5_name), getString(R.string.f5_license), getString(R.string.f5_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f5_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f6_name), getString(R.string.f6_license), getString(R.string.f6_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f6_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f7_name), getString(R.string.f7_license), getString(R.string.f7_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f7_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f8_name), getString(R.string.f8_license), getString(R.string.f8_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f8_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f9_name), getString(R.string.f9_license), getString(R.string.f9_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f9_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f10_name), getString(R.string.f10_license), getString(R.string.f10_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f10_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f11_name), getString(R.string.f11_license), getString(R.string.f11_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f11_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f12_name), getString(R.string.f12_license), getString(R.string.f12_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f12_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f13_name), getString(R.string.f13_license), getString(R.string.f13_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f13_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f14_name), getString(R.string.f14_license), getString(R.string.f14_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f14_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f15_name), getString(R.string.f15_license), getString(R.string.f15_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f15_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f16_name), getString(R.string.f16_license), getString(R.string.f16_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f16_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f17_name), getString(R.string.f17_license), getString(R.string.f17_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f17_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f18_name), getString(R.string.f18_license), getString(R.string.f18_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f18_name) + ".ttf")));
//        madapter.add(new Font(getString(R.string.f19_name), getString(R.string.f19_license), getString(R.string.f19_author), Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.f19_name) + ".ttf")));
        
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
                TextView tv4 = (TextView) v.findViewById(R.id.demo);
                
                tv1.setTypeface(o.getTypeface());
                tv4.setTypeface(o.getTypeface());
                
                if(tv1 != null) {
                    tv1.setText(o.getName());
                }
                if(tv2 != null) {
                    tv2.setText(o.getLicense());
                }
                if(tv3 != null) {
                    tv3.setText(" - " + o.getAuthor());
                }
                if(tv4 != null) {
                    tv4.setText(getString(R.string.demo));
                }
            }
            return v;
        }
    }
}