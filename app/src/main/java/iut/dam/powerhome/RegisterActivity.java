package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ]{2,25}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    private EditText editPrenom, editNom, editEmail, editMobile, editPassword;
    private Button buttonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView imageView = findViewById(R.id.imageRetour);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        editPrenom = findViewById(R.id.editTextText3);
        editNom = findViewById(R.id.editTextTextnom);
        editEmail = findViewById(R.id.editTextText4);
        editMobile = findViewById(R.id.editText8);
        editPassword = findViewById(R.id.editText5);
        buttonValider = findViewById(R.id.button);

        buttonValider.setOnClickListener(v -> {
            if (Validation()) {
                String prenom = editPrenom.getText().toString().trim();
                String nom = editNom.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String mobile = editMobile.getText().toString().trim();

                Intent intent = new Intent(RegisterActivity.this, RecapActivity.class);
                intent.putExtra("PRENOM", prenom);
                intent.putExtra("NOM", nom);
                intent.putExtra("EMAIL", email);
                intent.putExtra("MOBILE", mobile);
                startActivity(intent);
            }
        });


    }

    private boolean Validation(){
        String prenom = editPrenom.getText().toString().trim();
        String nom = editNom.getText().toString().trim();
        String password = editPassword.getText().toString().trim();


        // Vérification du prénom
        if (!NAME_PATTERN.matcher(prenom).matches()) {
            editPrenom.setError("Prénom invalide (2-25 lettres)");
            return false;
        }

        if (!NAME_PATTERN.matcher(nom).matches()) {
            editNom.setError("Nom invalide (2-25 lettres)");
            return false;
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            editPassword.setError("Mot de passe invalide : min. 8 caractères, 1 lettre, 1 chiffre, 1 symbole");
            return false;
        }

        return true;

    }

}