CPS613
======

Memorization Game Project

=================================================================================
public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		// Declare buttons
		final Button retryBtn = (Button) findViewById(R.id.retryBtn);
		final Button returnBtn = (Button) findViewById(R.id.returnBtn);
		
		// Add listeners to buttons
		retryBtn.setOnClickListener(mRetryListener);		
		returnBtn.setOnClickListener(mReturnListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	// Create an anonymous implementation of OnClickListener
	private OnClickListener mRetryListener = new OnClickListener() {
	    public void onClick(View v) {
	    	Intent aboutIntent = new Intent(v.getContext(), MainActivity.class);
		    startActivityForResult(aboutIntent,0);
		}
	};
	
	// Create an anonymous implementation of OnClickListener
	private OnClickListener mReturnListener = new OnClickListener() {
	    public void onClick(View v) {
	    	Intent aboutIntent = new Intent(v.getContext(), MainActivity.class);
	    	startActivityForResult(aboutIntent,0);
		}
	};
}

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".ResultActivity" >

    <Button
        android:id="@+id/retryBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="180dp"
        android:text="@string/retryBtn"
        android:textSize="14sp" />

    <Button
        android:id="@+id/returnBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/retryBtn"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="18dp"
        android:text="@string/returnBtn"
        android:textSize="14sp" />

    <TextView
        android:id="@+id/outro"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/retryBtn"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="68dp"
        android:text="@string/outro"
        android:textSize="16sp" />

</RelativeLayout>
=============================================================================
public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
}

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".AboutActivity" >

    <TextView
        android:id="@+id/textView5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="123dp"
        android:text="@string/david" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/textView5"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="34dp"
        android:text="@string/sajee" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@+id/textView5"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="17dp"
        android:text="@string/sean" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="66dp"
        android:text="@string/about"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView8"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="19dp"
        android:text="@string/version"
        android:textAppearance="?android:attr/textAppearanceMedium" />

    <TextView
        android:id="@+id/textView8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView2"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="14dp"
        android:text="@string/course"
        android:textAppearance="?android:attr/textAppearanceMedium" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="22dp"
        android:text="@string/ryerson"
        android:textAppearance="?android:attr/textAppearanceMedium" />

</RelativeLayout>
===============================================================================================
