package com.app.navigationitemswithtabsandcallback.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.navigationitemswithtabsandcallback.R;

public class HeaderRow extends LinearLayout {

    private Drawable cImg;
    private String cText = "";
    private int cTextStyle = 2;
    Context context;

    public HeaderRow(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public HeaderRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.HeaderRow,
                0, 0
        );

        try {
            // Retrieve the values from the TypedArray and store into
            // fields of this class.
            //
            // The R.styleable.PieChart_* constants represent the index for
            // each custom attribute in the R.styleable.PieChart array.
            try {
                cImg = a.getDrawable(R.styleable.HeaderRow_src);
            } catch (Exception e) {
                e.printStackTrace();
                cImg = context.getResources().getDrawable(R.mipmap.appicon);
            }
            cText = a.getString(R.styleable.HeaderRow_text);
            cTextStyle = a.getInteger(R.styleable.HeaderRow_textStyle,2);

        } finally {
            // release the TypedArray so that it can be reused.
            a.recycle();
        }

        init();
    }

    public Drawable getcImg() {
        return cImg;
    }

    public void setcImg(Drawable cImg) {
        this.cImg = cImg;
    }

    public String getcText() {
        return cText;
    }

    public void setcText(String cText) {
        this.cText = cText;
    }


    private void init() {
       LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.LEFT;
       this.setLayoutParams(layoutParams);
       this.setOrientation(VERTICAL);
        this.setPadding(0,0,0,0);
       this.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        /*ImageView imgView = new ImageView(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(R.dimen.menu_item_hi_wi,R.dimen.menu_item_hi_wi);
                //context.getResources().getDimension(R.dimen.menu_item_hi_wi),
                //context.getResources().getDimension(R.dimen.menu_item_hi_wi));
        imgView.setLayoutParams(layoutParams);
        imgView.setImageResource(cImg);
        //this.addView(imgView);

        TextView txtView = new TextView(context);
        LinearLayout.LayoutParams layoutParamsTxt = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        txtView.setLayoutParams(layoutParamsTxt);
        layoutParamsTxt.setMargins(R.dimen.activity_horizontal_margin,5,0,5);
        layoutParamsTxt.gravity = Gravity.CENTER;
        txtView.setTextColor(getResources().getColor(android.R.color.white));
        txtView.setText("cards");
        this.addView(txtView);*/
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_row_test, null, false);
        addView(view);

        ((ImageView)(view).findViewById(R.id.cimg)).setImageDrawable(cImg);
        TextView customText = (TextView)(view).findViewById(R.id.ctxt);
        customText.setText(cText);
        if(cTextStyle != 2){
        customText.setTypeface(null, (cTextStyle == 0)?Typeface.BOLD:Typeface.ITALIC);
        }


    }


}
