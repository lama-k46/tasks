package com.example.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextBirthYear;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextBirthYear = findViewById(R.id.editTextBirthYear);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWelcomeMessage();
            }
        });
    }

    private void showWelcomeMessage() {
        String name = editTextName.getText().toString().trim();
        String birthYearStr = editTextBirthYear.getText().toString().trim();

        // التحقق من وجود المعلومات
        if (name.isEmpty() || birthYearStr.isEmpty()) {
            textViewResult.setText("please insert all details");
            return;
        }

        // حساب العمر
        int birthYear;
        try {
            birthYear = Integer.parseInt(birthYearStr);
        } catch (NumberFormatException e) {
            textViewResult.setText("please enter the currect age");
            return;
        }

        int currentYear = 2024; // يمكنك الحصول على السنة الحالية بشكل ديناميكي إذا أردت
        int age = currentYear - birthYear;

        // إنشاء رسالة الترحيب
        String message = "Welcome، " + name + "your age " + age + "th";
        textViewResult.setText(message);
    }
}
