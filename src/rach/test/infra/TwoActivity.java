package rach.test.infra;

import rach.test.infra.MainActivity.PlaceholderFragment;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class TwoActivity extends Activity {
	
	private MyListFragment mapFrag;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		print("onCreate");
		setContentView(R.layout.activity_two);
		
//		// find the retained fragment on activity restarts
//        FragmentManager fm = getFragmentManager();
//        mapFrag = (MyListFragment) fm.findFragmentByTag("listMapFrag");
//
//        // create the fragment and data the first time
//        if (mapFrag == null) {
//            // add the fragment
//        	mapFrag = new MyListFragment();
//            fm.beginTransaction().add(mapFrag, "listMapFrag").commit();
//        }
		
		
//		if (savedInstanceState == null) {
//			
//			MyListFragment mlf = new MyListFragment();
//			
//			getFragmentManager().beginTransaction()
//			.add(R.id.container, mlf,"fragtag2").commit();
//		}
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
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container,
//					false);
//			return rootView;
//		}
//	}
	
	private void print(String s) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn, s);
	}

}
