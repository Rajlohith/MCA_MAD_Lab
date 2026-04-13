import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        TextView textViewMessage = findViewById(R.id.textViewMessage);

        Intent intent = getIntent();

        String receivedMessage = intent.getStringExtra("message_key");

        if (receivedMessage != null) {
            textViewMessage.setText(receivedMessage);
        }
    }
}