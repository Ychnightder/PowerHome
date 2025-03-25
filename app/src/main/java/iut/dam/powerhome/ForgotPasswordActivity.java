package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {


    private EditText emailInput, passwordInput , confirmPasswordInput;
    private Button buttonRetour , buttonValide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        emailInput  = findViewById(R.id.editTextEmail);
        passwordInput  = findViewById(R.id.editTextPassword);
        confirmPasswordInput = findViewById(R.id.editTextPasswordConfirm);
        buttonRetour  = findViewById(R.id.buttonRetour);
        buttonValide = findViewById(R.id.buttonValide);



        buttonRetour.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        buttonValide.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String passwordConfirm = confirmPasswordInput.getText().toString().trim();

            if (email.equals("abcd") && password.equals("EFGH") && passwordConfirm.equals(password)) {
                Toast.makeText(this, "Connexion réussie !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPasswordActivity.this, SplashActivity.class);
//                intent.putExtra("email", (CharSequence) emailInput);
//                intent.putExtra("password", (CharSequence) passwordInput);
                startActivity(intent);
                finish();
            }
        });
    }


}