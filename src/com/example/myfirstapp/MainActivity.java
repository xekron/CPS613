package com.example.myfirstapp;

import java.util.Random;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	private final static int NUM_OF_PAIRS = 12;
	private final Button startButton = (Button) findViewById(R.id.start_button);
	private final Button stopButton = (Button) findViewById(R.id.stop_button);
	public long countDownTime; // this value will be set by difficulty.
	private CountDownTimer initialTimer;
	private Shape shape1, shape2, shape3, shape4;
	private Shape shape5, shape6, shape7, shape8;
	private Shape shape9, shape10, shape11, shape12;
	private Shape[] shapes;
	private GameButton button1, button2, button3, button4, button5, button6;
	private GameButton button7, button8, button9, button10, button11, button12;
	private GameButton button13, button14, button15, button16, button17, button18;
	private GameButton button19, button20, button21, button22, button23, button24;
	private GameButton[] buttons;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// Hide the stop button initially, bring it back when start is selected
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
	
		// Set the button configurations
		initializeShapesAndButtons();
		Random r = new Random();
		int random = 0;
		// We pick a random shape that hasn't already been picked
		// twice, and assign it each button.
		for (int i = 0; i < NUM_OF_PAIRS*2; i++) {
			do {
				random = r.nextInt(NUM_OF_PAIRS);
			}
			while (shapes[random].isAllMatched());
			
			buttons[i].setImage(shapes[random].getType());
			shapes[random].incrementOccurrence();
		}
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
	
	private void initializeShapesAndButtons() {
		shape1 = new Shape(R.drawable.red_circle);
		shape2 = new Shape(R.drawable.yellow_circle);
		shape3 = new Shape(R.drawable.blue_circle);
		shape4 = new Shape(R.drawable.green_square);
		shape5 = new Shape(R.drawable.orange_square);
		shape6 = new Shape(R.drawable.purple_square);
		shape7 = new Shape(R.drawable.red_triangle);
		shape8 = new Shape(R.drawable.yellow_triangle);
		shape9 = new Shape(R.drawable.blue_triangle);
		shape10 = new Shape(R.drawable.green_star);
		shape11 = new Shape(R.drawable.orange_star);
		shape12 = new Shape(R.drawable.purple_star);
		shapes = new Shape[] {
				shape1, shape2, shape3, shape4, shape5,
					shape6, shape7, shape8, shape9, shape10, shape11, shape12
		};
		
		
		button1 = new GameButton((Button) findViewById(R.id.b1));
		button2 = new GameButton((Button) findViewById(R.id.b2));
		button3 = new GameButton((Button) findViewById(R.id.b3));
		button4 = new GameButton((Button) findViewById(R.id.b4));
		button5 = new GameButton((Button) findViewById(R.id.b5));
		button6 = new GameButton((Button) findViewById(R.id.b6));
		button7 = new GameButton((Button) findViewById(R.id.b7));
		button8 = new GameButton((Button) findViewById(R.id.b8));
		button9 = new GameButton((Button) findViewById(R.id.b9));
		button10 = new GameButton((Button) findViewById(R.id.b10));
		button11 = new GameButton((Button) findViewById(R.id.b11));
		button12 = new GameButton((Button) findViewById(R.id.b12));
		button13 = new GameButton((Button) findViewById(R.id.b13));
		button14 = new GameButton((Button) findViewById(R.id.b14));
		button15 = new GameButton((Button) findViewById(R.id.b15));
		button16 = new GameButton((Button) findViewById(R.id.b16));
		button17 = new GameButton((Button) findViewById(R.id.b17));
		button18 = new GameButton((Button) findViewById(R.id.b18));
		button19 = new GameButton((Button) findViewById(R.id.b19));
		button20 = new GameButton((Button) findViewById(R.id.b20));
		button21 = new GameButton((Button) findViewById(R.id.b21));
		button22 = new GameButton((Button) findViewById(R.id.b22));
		button23 = new GameButton((Button) findViewById(R.id.b23));
		button24 = new GameButton((Button) findViewById(R.id.b24));
		buttons = new GameButton [] {
				button1, button2, button3, button4, button5, button6,
				button7, button8, button9, button10, button11, button12,
				button13, button14, button15, button16, button17, button18,
				button19, button20, button21, button22, button23, button24,
		};
	}

}
