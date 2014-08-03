package com.rex.yangtzeu.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.rex.yangtzeu.R;
import com.rex.yangtzeu.Yangtzeu;
import com.rex.yangtzeu.config.Urls;
import com.rex.yangtzeu.http.YuHttp;
import com.rex.yangtzeu.regex.JwcRegex;

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
        if (view == get_score_btn) {
            new NetTask().execute("cet");
        }

    }

    // Async 查分
    private class NetTask extends AsyncTask<String, Void,String> {
        String optype;
        String cet_result = "";

        protected void onPostExecute(String result) {
            if(this.optype == "cet"){ // 渲染数据
                Toast.makeText(Yangtzeu.getInstance(),cet_result,Toast.LENGTH_LONG).show(); // TODO
            }
        }

        @Override
        protected String doInBackground(String... arg0) {
            this.optype = arg0[0];
            if(arg0[0] == "cet"){ // 网络获取数据

                try {
                    YuHttp.referer = "http://www.chsi.com.cn/cet/";
                    cet_result = YuHttp.get("http://www.chsi.com.cn/cet/query?zkzh=123456789012345&xm=%E6%9D%8E%E4%BF%8A", "utf-8"); //TODO
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}