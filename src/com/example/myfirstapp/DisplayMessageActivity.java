package com.example.myfirstapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

public class DisplayMessageActivity extends Activity {
	
	long countDownTime; // this value will be set by difficulty.

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		final TextView textView = new TextView(this);
		textView.setText(message);
		
		// TODO: Get difficulty, set countdown timer
		countDownTime = 10000; 
		
		CountDownTimer initialtimer = new CountDownTimer(countDownTime, 1) {
		    public void onTick(long millisUntilFinished) {
	        	 textView.setTextSize(20);
		         textView.setText("\n      " + (millisUntilFinished/1000)/60 + ":" 
		        		 + millisUntilFinished / 1000
		        		 + ":" + millisUntilFinished % 1000);
		     }

		    /**
		     * On finish, we want to either start the next timer and main game
		     * Or show the results screen
		     */
		     public void onFinish() {
		        	textView.setText("\n      Time's Up!");
		        	textView.setTextSize(20);
		        	textView.setTextColor(Color.RED);
		     }
		}.start();
		
		setContentView(textView);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
