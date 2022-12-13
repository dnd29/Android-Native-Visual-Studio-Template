package com.fgame.$ext_projectname$;

import android.app.Activity;
import android.widget.*;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.content.Intent;
import android.graphics.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.view.KeyEvent;


public class EditTextActivity extends Activity
{
	private Button mConfirm, mCancel;
	private EditText mEditText;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.dialog);

		mConfirm = (Button) findViewById(R.id.btnConfirm);
		mCancel = (Button) findViewById(R.id.btnCancel);
		mEditText = (EditText) findViewById(R.id.editText);
		mEditText.setText(GetStringFromNativeActivity());
    }

    public void confirmActivity(View v){
		SetString(mEditText.getText().toString());
		finish();
    }

	public void cancelActivity(View v){
		finish();
    }
	
    @Override
    protected void onDestroy() {
		SetfinishIMEMode();
        super.onDestroy();
    }

	public native Object GetNativeActivity();
	public native String GetStringFromNativeActivity();
	public native void SetString(String str);
	public native void SetfinishIMEMode();
	public static int getInt(int k){
		return k+1;
	}
	
	static{
		System.loadLibrary("$ext_projectname$");
	}
}