package com.beecub.golauncher.golauncherfonts;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class GOLauncherFontsActivity extends Activity {
    public static ArrayList<Font> mFonts = new ArrayList<Font>();
    public static FontAdapter madapter;
    public static final String LOG_TAG = "beecub";
    private int currentPosition;

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
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
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                
                Intent intent = new Intent(GOLauncherFontsActivity.this, DetailedPreviewActivity.class);
                Bundle b = new Bundle();
                b.putString("name", madapter.getItem(position).getName());
                b.putString("author", madapter.getItem(position).getAuthor());
                b.putString("license", madapter.getItem(position).getLicense());
                b.putString("link", madapter.getItem(position).getLink());
                b.putString("typeface", madapter.getItem(position).getTypeface());
                intent.putExtras(b);
                startActivity(intent);
                
                currentPosition = position;
                //finish();
                
            }
        });
        lv.setSelection(currentPosition);
        
        ImageButton bu1 = (ImageButton) findViewById(R.id.imageButton1);
        bu1.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                InfoDialog infoDialog = new InfoDialog(GOLauncherFontsActivity.this);                
                infoDialog.show();
            }
        });
        ImageButton bu2 = (ImageButton) findViewById(R.id.imageButton2);
        bu2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                HelpDialog helpDialog = new HelpDialog(GOLauncherFontsActivity.this);                
                helpDialog.show();
            }
        });
        
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
            madapter.add(new Font(fonts[i], fonts[i+1], fonts[i+2], fonts[i+3], "fonts/" + fonts[i] + ".ttf"));
            i = i + 5;
        } 
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.help:
            HelpDialog helpDialog = new HelpDialog(this);
            helpDialog.show();
            return true;
        case R.id.infocredits:
            InfoDialog infoDialog = new InfoDialog(this);
            infoDialog.show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
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
                
                if(tv1 != null) {
                    tv1.setText(o.getName());
                    tv1.setTypeface(Typeface.createFromAsset(getAssets(), o.getTypeface()));
                }
                if(tv2 != null) {
                    tv2.setText(o.getLicense());
                }
                if(tv3 != null) {
                    tv3.setText(" - " + o.getAuthor());
                }
                if(tv4 != null) {
                    tv4.setText(getString(R.string.demo));
                    tv4.setTypeface(Typeface.createFromAsset(getAssets(), o.getTypeface()));
                }
            }
            return v;
        }
    }
}
