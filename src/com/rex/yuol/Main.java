package com.rex.yuol;

import com.rex.yuol.utils.HttpUtils;

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
        btn1=(Button)this.findViewById(R.id.button1);
        btn1.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
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
		try{
			String s=HttpUtils.get("http://wap.baidu.com",this);
//			Log.i("http",s);
//			Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
		}catch(Exception e2){
			Log.e("geterr",e2.getMessage());
		}
	}



}
