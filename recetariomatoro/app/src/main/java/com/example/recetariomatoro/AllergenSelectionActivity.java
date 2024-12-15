package com.example.recetariomatoro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllergenSelectionActivity extends AppCompatActivity {

    ArrayList<String> selectedAllergens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergen_selection);

        ListView lvAllergens = findViewById(R.id.lv_allergens);
        Button btnFilter = findViewById(R.id.btn_filter);

        // Lista de posibles alérgenos
        String[] allergens = {"Gluten", "Leche", "Huevos", "Mariscos", "Cacahuates", "Soya", "Frutos secos"};

        // Adaptador para mostrar alérgenos
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, allergens);
        lvAllergens.setAdapter(adapter);
        lvAllergens.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnFilter.setOnClickListener(v -> {
            selectedAllergens.clear();
            for (int i = 0; i < lvAllergens.getCount(); i++) {
                if (lvAllergens.isItemChecked(i)) {
                    selectedAllergens.add(allergens[i]);
                }
            }

            ArrayList<String> selectedIngredients = getIntent().getStringArrayListExtra("selectedIngredients");

            Intent intent = new Intent(AllergenSelectionActivity.this, RecipeResultsActivity.class);
            intent.putStringArrayListExtra("selectedIngredients", selectedIngredients);
            intent.putStringArrayListExtra("selectedAllergens", selectedAllergens);
            startActivity(intent);
        });
    }
}
