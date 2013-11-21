package com.example.myfirstapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameButton {
	private boolean flipped;
	private static Integer currentSelectedShape;
	private static GameButton currentSelectedButton;
	public static int numMatched;
	private final static Integer EMPTY_BUTTON = R.drawable.empty;
	private Integer setImage;
	private final Button gameButton;
	private final GameButton thisButton;

	public GameButton(Button button) {
		this.gameButton = button;
		flipped = false;
		currentSelectedShape = 0;
		currentSelectedButton = null;
		numMatched = 0;
		thisButton = this;
	}

	public void setImage(Integer image) {
		setImage = image;

		setClickListener();
	}

	public void flip() {
		if (flipped) {
			gameButton.setBackgroundResource(EMPTY_BUTTON);
			flipped = false;
		} else {
			gameButton.setBackgroundResource(setImage);
			flipped = true;
		}
	}

	public void setClickListener() {
		gameButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flip();
				if (currentSelectedShape == setImage) {
					// Same shape previously selected, do nothing but
					// reset shapes to match.
					numMatched++;
					currentSelectedShape = 0;
					currentSelectedButton = null;
				} else if (currentSelectedShape == 0) {
					// This is the start of a new pair, set current
					// selected to this button shape.
					currentSelectedShape = setImage;
					currentSelectedButton = thisButton;
				} else {
					// Otherwise wrong match. Reset both cards/buttons.
					gameButton.postDelayed(new Runnable() {

						@Override
						public void run() {
							currentSelectedButton.flip();
							flip();
							currentSelectedShape = 0;
							currentSelectedButton = null;
						}
					}, 200);
				}
			}
		});
	}

	public void setEnabled(boolean enable) {
		gameButton.setEnabled(enable);
	}
}
