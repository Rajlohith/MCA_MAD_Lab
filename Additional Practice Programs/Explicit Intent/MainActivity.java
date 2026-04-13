import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    
    EditText inputUser;
    Button btnFetch;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUser = findViewById(R.id.inputUser);
        btnFetch = findViewById(R.id.btnFetch);
        resultView = findViewById(R.id.resultView);

        btnFetch.setOnClickListener(view -> {
            String username = inputUser.getText().toString();

            new Thread(() -> {
                String data = fetch(username);

                runOnUiThread(() -> {
                    resultView.setText(data);
                });
            }).start();
        });
    }

    private String fetch(String gitHubId) {
        try {
            String url = "https://api.github.com/users/" + gitHubId;

            Response response = new OkHttpClient()
                .newCall(new Request.Builder().url(url).build())
                .execute();

            var json = new org.json.JSONObject(response.body().string());

            return
                "Name: " + json.optString("name") + "\n" +
                "Username: " + json.getString("login") + "\n" +
                "Followers: " + json.getInt("followers") + "\n" +
                "Following: " + json.getInt("following") + "\n" +
                "Public Repos: " + json.getInt("public_repos");

        } catch (Exception e) {
            return "Error";
        }
    }
}
