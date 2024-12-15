package com.example.recetariomatoro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button btnBebidas = findViewById(R.id.btn_bebidas);
        Button btnPostres = findViewById(R.id.btn_postres);
        Button btnEnsaladas = findViewById(R.id.btn_ensaladas);
        Button btnMariscos = findViewById(R.id.btn_mariscos);
        Button btnCarnes = findViewById(R.id.btn_carnes);
        Button btnSalir = findViewById(R.id.btn_salir);

        btnBebidas.setOnClickListener(v -> navigateToIngredients("Bebidas"));
        btnPostres.setOnClickListener(v -> navigateToIngredients("Postres"));
        btnEnsaladas.setOnClickListener(v -> navigateToIngredients("Ensaladas"));
        btnMariscos.setOnClickListener(v -> navigateToIngredients("Mariscos"));
        btnCarnes.setOnClickListener(v -> navigateToIngredients("Carnes"));

        btnSalir.setOnClickListener(v -> finishAffinity());
    }

    private void navigateToIngredients(String category) {
        Intent intent = new Intent(MainMenuActivity.this, IngredientSelectionActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
