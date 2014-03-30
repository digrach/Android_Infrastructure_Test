package rach.test.infra;

import java.util.Observable;
import java.util.Observer;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyListFragment extends Fragment implements Observer{

	MyObservableThing myObservableThing = new MyObservableThing();

//		@Override
//		public void onCreate(Bundle savedInstanceState) {
//			super.onCreate(savedInstanceState);
//			//populateListView();
//	//		myObservableThing.addObserver(this);
//	//		myObservableThing.addToList("String 1");
//		}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	    View v = inflater.inflate(R.id.fuck, container, false);

//	    // For example, getting a TextView
//	    ListView tv = (TextView) v.findViewById(R.id.myTextView);
//	    // do your job

	    return v;
	}



//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		// Inflate the layout for this fragment
////		return inflater.inflate(getActivity().findViewById(R.id.listfuckfrag).getId(), container, false);
//		return inflater.inflate((R.id.listfuckfrag), container, false);
//
//	}
	
	@Override
	public void onStart() {
		populateListView();
	}


	public void populateListView() {
		print("populateListView");
//		ListView l = (ListView)this.getView().findViewById(R.id.string_list_two);
//		l.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,myObservableThing.getStringList()));
	}

	@Override
	public void update(Observable observable, Object data) {
		populateListView();
	}

	private void print(String s) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn, s);
	}





}
