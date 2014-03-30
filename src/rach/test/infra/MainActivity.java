package rach.test.infra;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends Activity implements Observer {

	private MyObservableThing myObservableThing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		print("onCreate");
		
		Intent i  = new Intent(this,TwoActivity.class);
		startActivity(i);
		
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment(),"fragtag").commit();
			myObservableThing = new MyObservableThing();
			myObservableThing.addObserver(this);
		}
	}

	@Override
	public void onStart() {
		super.onStart();
		print("onStart");
		populateListView();
		myObservableThing.addToList("First String");	
		myObservableThing.addToList("First String");
	}

	public void populateListView() {
		print("populateListView");
		if (myObservableThing != null) {
			ListView l = (ListView)this.findViewById(R.id.string_list);
			l.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myObservableThing.getStringList()));

		} else {
			print("populateListView + mo is NULL");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void update(Observable observable, Object data) {
		print("update");
		populateListView();

	}

	private void print(String s) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn, s);
	}

}
