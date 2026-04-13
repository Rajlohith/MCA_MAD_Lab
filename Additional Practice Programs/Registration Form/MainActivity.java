package my.appp.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etFullName, etRegisterNo, etDOB, etEmail, etPhone, etAddress;
    RadioGroup rgGender;
    Spinner spinnerDept;
    RadioGroup rgYear, rgSemester;
    EditText etSection;
    Spinner spinnerBlood;
    EditText etNationality, etFatherName, etMotherName, etParentPhone, etAadhar;
    RadioGroup rgTransport, rgAccommodation;
    CheckBox cbTC, cbMarkSheet, cbPhotos, cbAadharCopy, cbCommCert, cbIncomeCert;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linkViews();
        setupDepartmentSpinner();
        setupBloodGroupSpinner();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void linkViews() {
        etFullName = findViewById(R.id.etFullName);
        etRegisterNo = findViewById(R.id.etRegisterNo);
        etDOB = findViewById(R.id.etDOB);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        rgGender = findViewById(R.id.rgGender);
        spinnerDept = findViewById(R.id.spinnerDept);
        rgYear = findViewById(R.id.rgYear);
        rgSemester = findViewById(R.id.rgSemester);
        etSection = findViewById(R.id.etSection);
        spinnerBlood = findViewById(R.id.spinnerBlood);
        etNationality = findViewById(R.id.etNationality);
        etFatherName = findViewById(R.id.etFatherName);
        etMotherName = findViewById(R.id.etMotherName);
        etParentPhone = findViewById(R.id.etParentPhone);
        etAadhar = findViewById(R.id.etAadhar);
        rgTransport = findViewById(R.id.rgTransport);
        rgAccommodation= findViewById(R.id.rgAccommodation);
        cbTC = findViewById(R.id.cbTC);
        cbMarkSheet = findViewById(R.id.cbMarkSheet);
        cbPhotos = findViewById(R.id.cbPhotos);
        cbAadharCopy = findViewById(R.id.cbAadharCopy);
        cbCommCert = findViewById(R.id.cbCommCert);
        cbIncomeCert = findViewById(R.id.cbIncomeCert);
        btn = findViewById(R.id.btnSubmit);
    }
    private void setupDepartmentSpinner() {
        String[] departments = {
                "Select Department",
                "B.E. in Aerospace Engineering",
                "B.E. in Biotechnology",
                "B.E. in Civil Engineering",
                "B.E. in Computer Science and Engineering",
                "B.E. in Electrical and Electronics Engineering",
                "B.E. in Mechanical Engineering",
                "M.Tech. in Biotechnology",
                "M.Tech. in Computer Science and Engineering",
                "M.Tech. in VLSI Design & Embedded Systems"
        };
        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                departments
        );
        deptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDept.setAdapter(deptAdapter);
    }
    private void setupBloodGroupSpinner() {
        String[] bloodGroups = {
                "Select Blood Group",
                "A+", "A−", "B+", "B−",
                "AB+", "AB−", "O+", "O−"
        };
        ArrayAdapter<String> bloodAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                bloodGroups
        );
        bloodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBlood.setAdapter(bloodAdapter);
    }
    private void submitForm() {
        String name = etFullName.getText().toString().trim();
        String regNo = etRegisterNo.getText().toString().trim();
        String dob = etDOB.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        if (name.isEmpty()) {
            etFullName.setError("Full name is required");
            etFullName.requestFocus();
            return;
        }
        if (regNo.isEmpty()) {
            etRegisterNo.setError("Register number is required");
            etRegisterNo.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etPhone.setError("Phone number is required");
            etPhone.requestFocus();
            return;
        }
        if (spinnerDept.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Please select your department",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (rgYear.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select your year of study",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Registration Submitted Successfully!",
                Toast.LENGTH_LONG).show();
    }
}