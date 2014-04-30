package android.app.assignment2;

import android.app.Activity;
import android.app.assignment2.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class SingleListItem extends Activity {

	private double downXValue;
	private ListView lv;
	//this is the bug, here call the rating but in the xml layout files there are no rating
	//when using a component, it must have an id in layout, thus not having any will 
	//crash the software
	// + this rating is not used.. said HUNG
	private RatingBar r;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appetizer);
		lv = (ListView) findViewById(R.id.list_ingredients);
		String[] menu = { "6 or 7 ripe plum tomatoes (about 1 1/2 lbs)",
				"2 cloves garlic, minced", "1 Tbsp extra virgin olive oil",
				"1 teaspoon balsamic vinegar",
				"6-8 fresh basil leaves, chopped",
				"Salt and freshly ground black pepper to taste",
				"1 baguette French bread or similar Italian bread",
				"1/4 cup olive oil" };
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.simple_row, menu);
		lv.setAdapter(listAdapter);
		r = (RatingBar) findViewById(R.id.cookie_rating);
		r.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				Toast.makeText(SingleListItem.this, "Thank for Rating", Toast.LENGTH_LONG).show();
				r.setIsIndicator(true);
				
			}
		});
		// LinearLayout layout = (LinearLayout)
		// findViewById(R.id.layout_recipe);
		// layout.setOnTouchListener((OnTouchListener) this);

	}

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
			ViewFlipper vf = (ViewFlipper) findViewById(R.id.recipe_switch);
			// going backwards: pushing stuff to the right
			if (downXValue < currentX) {
				// Get a reference to the ViewFlipper
				vf.setInAnimation(inFromLeftAnimation());
				vf.setOutAnimation(outToRightAnimation());
				vf.showPrevious();
			}
			if (downXValue > currentX) {
				// Get a reference to the ViewFlipper
				vf.setInAnimation(inFromRightAnimation());
				vf.setOutAnimation(outToLeftAnimation());
				vf.showNext();
			}

			break;
		}
		}

		// if you return false, these actions will not be recorded
		return true;
	}

	public int getType() {
		Intent i = new Intent();
		int id = 0;
		String a = i.getStringExtra("type");
		if (a == "Apetizer")
			id = 1;
		if (a == "Breakfast and Brunch")
			id = 2;
		if (a == "Bakery")
			id = 3;
		if (a == "Casserole")
			id = 4;
		if (a == "Cookies")
			id = 5;
		if (a == "Dessert")
			id = 6;
		if (a == "Main Course")
			id = 7;
		if (a == "Salad")
			id = 8;
		if (a == "Sandwich")
			id = 9;
		if (a == "Side Dish")
			id = 10;
		if (a == "Soup and Stew")
			id = 11;

		return id;
	}
}
