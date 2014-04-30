package android.app.assignment2;

import android.app.ListActivity;
import android.app.assignment2.R;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListMenu extends ListActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.menu);
		ListView lv = (ListView) findViewById(R.id.listmenu);
		//String[] menu = getResources().getStringArray(R.array.menu_list);
		//lv.setAdapter(new ArrayAdapter<String>(this, R.layout.menu,				R.id.rowTextView, menu));

		// listening to single list item on click
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {

				// selected item
				// String product = ((TextView)view).getText().toString();

				// Launching new Activity on selecting single List Item
				// Intent i = new Intent(getApplicationContext(),
				// SingleListItem.class);
				// sending data to new activity
				// i.putExtra("product", product);
				// startActivity(i);
			}
		});
	}

}
