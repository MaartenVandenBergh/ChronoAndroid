package view;

import model.IModel;
import model.ITriggerFactory;
import model.Model;

import com.example.chronoandroid.R;

import controller.Controller;
import controller.IController;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;

public class MainActivity extends Activity implements IView {
	IController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(controller == null){
			IModel model = new Model(ITriggerFactory.UTIL_TRIGGER, 1000);
			model.addView(this);
			this.controller = new Controller(model);
		}
		
		Configuration newConfig = getResources().getConfiguration();
		adaptLayoutToOrientation(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		adaptLayoutToOrientation(newConfig);
	}
	@Override
	public void update() {
		runOnUiThread(new Runnable() {
		     public void run() {

		    	 TextView t = (TextView) findViewById(R.id.textView1);
		 		String s = formatChrono(controller.getHours(), controller.getMinutes(), controller.getSeconds());
		 		t.setText(s);

		    }
		});
	}
	public void startButtonAction(View view){
		if(controller.isTriggerRunning() || controller.getHours() > 0 || controller.getMinutes() >0 || controller.getSeconds() >0){
			controller.stopTrigger();
			controller.reset();
			((Button)view).setText("Start");
			((Button) findViewById(R.id.pauseButton)).setText("Pause");
		}
		else{
			controller.reset();
			controller.startTrigger();
			((Button)view).setText("Reset");
			((Button) findViewById(R.id.pauseButton)).setText("Pause");
		}
	}
	public void pauseButtonAction(View view){
		if(controller.isTriggerRunning()){
			controller.stopTrigger();
			((Button)view).setText("Continue");
		}
		else if(controller.getHours() != 0 || controller.getMinutes() != 0 || controller.getSeconds() != 0){
			controller.startTrigger();
			((Button)view).setText("Pause");
		}
	}
	private String formatChrono(int hours, int minutes, int seconds){
		String sec = Integer.toString(seconds);
		String min = Integer.toString(minutes);
		String h = Integer.toString(hours);
		
		if(seconds <10){
			sec = "0"+sec;
		}
		if(minutes <10){
			min = "0"+min;
		}
		if(hours <10){
			h = "0"+h;
		}
		return h+":"+min+":"+sec;
	}
	private void adaptLayoutToOrientation(Configuration newConfig){
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_landscape);
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_portrait);         
        }
		update();
	}
}
