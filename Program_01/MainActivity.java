package my.appp.my;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ProgressBar pB = findViewById(R.id.progressBar2);
        TextView pT = findViewById(R.id.textView);
        Button btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(v -> {
            startProgress(pB, pT);
        });
    }

    private void startProgress(ProgressBar pB, TextView pT) {

        new Thread(() -> {

                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                    final int progress = i;

                    runOnUiThread(() -> {

                            pB.setProgress(progress);
                            pT.setText("Progress: " + progress + "%");

                            if (progress == 100) {
                                new AlertDialog.Builder(MainActivity.this)
                                    .setMessage("Download Complete")
                                    .setPositiveButton("OK", (dialog, which) -> finish())
                                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                                    .show();
                            }
                    });
                }
        }).start();
    }
}