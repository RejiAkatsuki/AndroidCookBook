package android.app.assignment2;

import android.app.TabActivity;
import android.app.assignment2.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostActivity extends TabActivity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        
        //this.onBackPressed();
 
        TabHost tabHost = getTabHost();
 
        TabSpec searchspec = tabHost.newTabSpec("Search");
        // setting Title and Icon for the Tab
        searchspec.setIndicator("Search", getResources().getDrawable(R.drawable.icon_search_tab));
        Intent searchIntent = new Intent(this, SearchActivity.class);
        searchspec.setContent(searchIntent);
 
        TabSpec topspec = tabHost.newTabSpec("Top Rate");
        topspec.setIndicator("Top Rate", getResources().getDrawable(R.drawable.icon_top_tab));
        Intent topIntent = new Intent(this, TopActivity.class);
        topspec.setContent(topIntent);
 
        TabSpec newspec = tabHost.newTabSpec("New");
        newspec.setIndicator("New", getResources().getDrawable(R.drawable.icon_new_tab));
        Intent newIntent = new Intent(this, NewActivity.class);
        newspec.setContent(newIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(searchspec); 
        tabHost.addTab(topspec);
        tabHost.addTab(newspec); 
        
    }
}