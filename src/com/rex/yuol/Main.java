package com.rex.yuol;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements android.view.View.OnClickListener{
	private Button btn1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        btn1=(Button)this.findViewById(R.id.button1);
//        btn1.setOnClickListener(this);
    }


    
	/* 按后退键则关闭程序
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			System.exit(0);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://wap.baidu.com", new AsyncHttpResponseHandler() {
		    @Override
		    public void onSuccess(String response) {
		    	Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();;
		    }
		});
	}

}
