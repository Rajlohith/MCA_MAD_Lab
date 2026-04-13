package my.appp.activitylifecycle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onStart(): The UI is now visible.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart(): The UI is now visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume(): The app is now interactive.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause(): Focus lost. Save unsaved data here.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop(): App is hidden. Release heavy resources.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart(): Preparing to show a hidden activity.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy(): Final cleanup before removal from memory.");
    }
}