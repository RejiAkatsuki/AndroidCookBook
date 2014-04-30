package android.app.assignment2;

import android.app.Activity;
import android.app.assignment2.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainView extends Activity implements OnTouchListener {
	private float downXValue;
	private ListView lv;
	private Database db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout_main);
		layout.setOnTouchListener((OnTouchListener) this);
		lv = (ListView) findViewById(R.id.listmenu);
		String[] menu = getResources().getStringArray(R.array.menu_list);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.simple_row, menu);
		lv.setAdapter(listAdapter);
		lv.setClickable(true);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("test on selected item", "Lolo");
				Intent i = new Intent(MainView.this, SingleListItem.class);
				// sending data to new activity
				startActivity(i);
			}
		});
		Button bt = (Button)findViewById(R.id.search_Button);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a = new Intent(MainView.this, TabHostActivity.class);
				// sending data to new activity
				startActivity(a);
			}
		});
	}

	// for the previous movement
	public static Animation inFromRightAnimation() {

		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(350);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	public static Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(350);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	// for the next movement
	public static Animation inFromLeftAnimation() {
		Animation inFromLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(350);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;
	}

	public static Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(350);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {

		Log.e("Test on tough", "This work");
		// Get the action that was done on this touch event
		switch (arg1.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			// store the X value when the user's finger was pressed down
			downXValue = arg1.getX();
			break;
		}
		case MotionEvent.ACTION_UP: {
			// Get the X value when the user released his/her finger
			float currentX = arg1.getX();
			ViewFlipper vf = (ViewFlipper) findViewById(R.id.layoutswitcher);
			// going backwards: pushing stuff to the right
			if (vf.getCurrentView().getId() == R.id.main_view) {
				if (downXValue > currentX) {
					// Get a reference to the ViewFlipper
					vf.setInAnimation(inFromRightAnimation());
					vf.setOutAnimation(outToLeftAnimation());
					vf.showNext();
				}
				
			} else {
				if (downXValue < currentX) {
					// Get a reference to the ViewFlipper
					vf.setInAnimation(inFromLeftAnimation());
					vf.setOutAnimation(outToRightAnimation());
					vf.showPrevious();
				}

				// going forwards: pushing stuff to the left
				if (downXValue > currentX) {
					Intent i = new Intent(MainView.this, SingleListItem.class);
					// sending data to new activity
					startActivity(i);
				}
			}

			break;
		}
		}

		// if you return false, these actions will not be recorded
		return true;
	}
}
