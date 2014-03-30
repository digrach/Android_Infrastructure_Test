package rach.test.settings;

import java.util.ArrayList;
import java.util.List;

import rach.test.infra.MainActivity;
import rach.test.infra.MyObservableThing;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;

public class InfraApp extends Application{
	
	List<Activity> activityList;
	
	
	@Override
	public void onCreate() {
		
//		initiateActivityList();
//		launchStartActivity();
	}
	
	private void initiateActivityList() {
		activityList = new ArrayList<Activity>();
		
		activityList.add(new MainActivity());
	}
	
	private void launchStartActivity() {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}

}
