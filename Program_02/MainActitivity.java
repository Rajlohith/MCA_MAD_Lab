import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextMessage = findViewById(R.id.editText);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String message = editTextMessage.getText().toString();

                Intent intent = new Intent(MainActivity.this, Screen2.class);
                intent.putExtra("message_key", message);

                startActivity(intent);
        });
    }
}