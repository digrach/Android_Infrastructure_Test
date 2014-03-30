package rach.test.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import android.util.Log;

public class MyObservableThing extends Observable {


	private List<String> stringList = new ArrayList<String>();
	private List<Observer> oList = new ArrayList<Observer>();

	public void addToList(String s) {
		print("addToListing");
		stringList.add(s);
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		synchronized (oList) {
			for (Observer o : oList) {
				o.update(this, null);
			}
		}
	}

	public List<String> getStringList() {
		print("getStringList");
		return stringList;
	}

	@Override
	public void addObserver(Observer o) {
		print("addObserver");
		synchronized (oList) {
			oList.add(o);
		}
		print("addObserver: list size: " + Integer.toString(oList.size()));

	}

	@Override
	public void deleteObserver(Observer o) {
		print("deleteObserver");
		synchronized (oList) {
			oList.remove(o);
		}
	}

	private void print(String s) {
		String cn = this.getClass().getSimpleName();
		Log.d("***" + cn, s);
	}






}
