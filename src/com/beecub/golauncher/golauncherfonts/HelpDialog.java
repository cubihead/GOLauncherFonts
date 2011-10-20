package com.beecub.golauncher.golauncherfonts;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class HelpDialog extends Dialog {
    private Context context;

    public HelpDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_help);
        setTitle(context.getString(R.string.help));
        TextView tv = (TextView) findViewById(R.id.instructionadvanced);
        tv.setText(context.getString(R.string.instructionadvanced));
    }
}
