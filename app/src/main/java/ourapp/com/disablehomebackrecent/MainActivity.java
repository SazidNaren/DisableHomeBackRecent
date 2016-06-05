package ourapp.com.disablehomebackrecent;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onPause() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);
        super.onPause();
    }
    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_HOME)
            return true;
        else
        return super.onKeyDown(keyCode, event);
    }

    @Override
     protected void onUserLeaveHint() {
        Toast.makeText(MainActivity.this,"home pressed",Toast.LENGTH_SHORT).show();
       // onResume();
        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(1,
                System.currentTimeMillis(),
                PendingIntent.getActivity(this, 0, new Intent(this,MainActivity.class), 0));
        super.onUserLeaveHint();
    }


}
