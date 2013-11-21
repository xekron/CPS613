package com.example.myfirstapp;

import java.util.Random;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	public long countDownTime; // this value will be set by difficulty.
	private CountDownTimer initialTimer;
	private int numOfImages = 25;
	private static final int MIN_IMAGES = 1;
	private static final int MAX_IMAGES = 6;
	private boolean[] matched = { false, false, false, false, false, false, false };
	private int[] numOfMatched = { 0, 0, 0, 0, 0, 0, 0 };

	public Integer[] thumbIds = { R.drawable.empty, 
			R.drawable.red_circle, R.drawable.yellow_circle, R.drawable.blue_circle, 
			R.drawable.green_square, R.drawable.orange_square, R.drawable.purple_square,
			R.drawable.red_triangle, R.drawable.yellow_triangle, R.drawable.blue_triangle, 
			R.drawable.green_star, R.drawable.orange_star, R.drawable.purple_star};
	public Integer[] randomizedThumbs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button startButton = (Button) findViewById(R.id.start_button);
		final Button stopButton = (Button) findViewById(R.id.stop_button);

		stopButton.setVisibility(View.GONE);
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// When start is clicked, show stop and hide start
				startTimer(v);
				startButton.setVisibility(View.GONE);
				stopButton.setVisibility(View.VISIBLE);
			}
		});

		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// When stop is clicked, show start again and hide stop
				stopTimer();
				stopButton.setVisibility(View.GONE);
				startButton.setVisibility(View.VISIBLE);
			}
		});

		// Create a randomized array of all the images
		randomizedThumbs = new Integer[numOfImages];
		Random r = new Random();
		int random = 1;
		int prev = 0;
		for (int i = 1; i < randomizedThumbs.length; i++) {
			do {
			//	while (random == prev) {
					random = r.nextInt(MAX_IMAGES - MIN_IMAGES + 1) + MIN_IMAGES;
				//}
				randomizedThumbs[i] = thumbIds[random];
			/*	if (numOfMatched[random] == 2)  {
					matched[random] = true;
				}
				else if (numOfMatched[random] < 2){
					numOfMatched[random]++;
				}
				prev = random;*/
			} while (matched[random] == true);
		}
		
		new GameButton((Button) findViewById(R.id.b1),false,randomizedThumbs,1);
		new GameButton((Button) findViewById(R.id.b2),false,randomizedThumbs,2);
		new GameButton((Button) findViewById(R.id.b3),false,randomizedThumbs,3);
		new GameButton((Button) findViewById(R.id.b4),false,randomizedThumbs,4);
		new GameButton((Button) findViewById(R.id.b5),false,randomizedThumbs,5);
		new GameButton((Button) findViewById(R.id.b6),false,randomizedThumbs,6);
		new GameButton((Button) findViewById(R.id.b7),false,randomizedThumbs,7);
		new GameButton((Button) findViewById(R.id.b8),false,randomizedThumbs,8);
		new GameButton((Button) findViewById(R.id.b9),false,randomizedThumbs,9);
		new GameButton((Button) findViewById(R.id.b10),false,randomizedThumbs,10);
		new GameButton((Button) findViewById(R.id.b11),false,randomizedThumbs,11);
		new GameButton((Button) findViewById(R.id.b12),false,randomizedThumbs,12);
		new GameButton((Button) findViewById(R.id.b13),false,randomizedThumbs,13);
		new GameButton((Button) findViewById(R.id.b14),false,randomizedThumbs,14);
		new GameButton((Button) findViewById(R.id.b15),false,randomizedThumbs,15);
		new GameButton((Button) findViewById(R.id.b16),false,randomizedThumbs,16);
		new GameButton((Button) findViewById(R.id.b17),false,randomizedThumbs,17);
		new GameButton((Button) findViewById(R.id.b18),false,randomizedThumbs,18);
		new GameButton((Button) findViewById(R.id.b19),false,randomizedThumbs,19);
		new GameButton((Button) findViewById(R.id.b20),false,randomizedThumbs,20);
		new GameButton((Button) findViewById(R.id.b21),false,randomizedThumbs,21);
		new GameButton((Button) findViewById(R.id.b22),false,randomizedThumbs,22);
		new GameButton((Button) findViewById(R.id.b23),false,randomizedThumbs,23);
		new GameButton((Button) findViewById(R.id.b24),false,randomizedThumbs,24);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startTimer(View view) {
		// TODO: Find difficulty here
		// Set difficulty, or send it to the timer method.
		countDownTime = 10000;
		startTimer(countDownTime);
	}

	public void startTimer(long countDownTime) {
		final TextView textView = (TextView) findViewById(R.id.timer_message);
		// TODO: Get difficulty, set countdown time
		initialTimer = new CountDownTimer(countDownTime, 1) {
			public void onTick(long millisUntilFinished) {
				textView.setTextSize(20);
				textView.setTextColor(Color.BLACK);
				textView.setText(" " + (millisUntilFinished / 1000) / 60 + ":"
						+ millisUntilFinished / 1000 + ":"
						+ millisUntilFinished % 1000);
			}

			/**
			 * On finish, we want to either start the next timer and main game
			 * Or show the results screen
			 */
			public void onFinish() {
				textView.setText(" Time's Up!");
				textView.setTextSize(20);
				textView.setTextColor(Color.RED);
			}
		}.start();
	}

	public void stopTimer() {
		initialTimer.cancel();
	}

}
