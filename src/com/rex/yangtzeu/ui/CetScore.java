package com.rex.yangtzeu.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.rex.yangtzeu.R;

/**
 * Created by rex on 2014/7/30.
 */
public class CetScore extends Activity implements
        android.view.View.OnClickListener{
    private Button get_score_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cet_score);

        // 标题栏按钮动作
        get_score_btn = (Button) this.findViewById(R.id.get_score_btn);
        get_score_btn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 更改为按下时的背景图片
                    v.setBackgroundResource(R.drawable.yangtzeu_main_title);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // 改为抬起时的图片
                    v.setBackgroundResource(R.drawable.yangtzeu_title_btn_bg);
                }
                return false;
            }
        });

        get_score_btn.setOnClickListener(this);
    }

    /**
     * 按键事件
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 后退动画
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.back_left_in,
                    R.anim.back_right_out);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {

    }
}