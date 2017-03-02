package com.longsh.optionframelibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longsh.optionframelibrary.adapter.BottomPopuAdapter;

import java.util.List;

/**
 * Created by q805699513 on 2016/12/14.
 */

public class OptionBottomDialog extends PopupWindow {

    private final ListView listView;

    public OptionBottomDialog(Context context, List<String> listData) {
        super(context);
        final Activity activity = (Activity) context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pupview, null);
        this.setContentView(view);
        this.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout review = (RelativeLayout) view.findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        TextView quxiao = (TextView) view.findViewById(R.id.quxiao);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        listView = (ListView) view.findViewById(R.id.list);
        final BottomPopuAdapter popuSFAdapter = new BottomPopuAdapter(context, listData);
        listView.setAdapter(popuSFAdapter);


        // 设置外部可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
//        ColorDrawable dw = new ColorDrawable(Color.parseColor("#90000000"));
        this.setBackgroundDrawable(new BitmapDrawable());

        this.setAnimationStyle(R.style.Animation);

        this.showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        backgroundAlpha(0.65f,activity);
        this.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backgroundAlpha(1.0f,activity);
                    }
                },290);
            }
        });
    }

    public void setItemClickListener(AdapterView.OnItemClickListener listener) {
        listView.setOnItemClickListener(listener);
    }

    public void backgroundAlpha(float bgAlpha,Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }
}
