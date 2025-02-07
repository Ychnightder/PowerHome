package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        Button buttonRetour = findViewById(R.id.buttonRetour);
        buttonRetour.setOnClickListener(v -> {
            Intent intent = new Intent(RecapActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        Intent intent = getIntent();
        String prenom = intent.getStringExtra("PRENOM");
        String nom = intent.getStringExtra("NOM");
        String email = intent.getStringExtra("EMAIL");
        String mobile = intent.getStringExtra("MOBILE");

        // Afficher les données
        TextView recapText = findViewById(R.id.recapText);
        recapText.setText("Prénom : " + prenom + "\nNom : " + nom + "\nEmail : " + email + "\nMobile : " + mobile);
    }

}
