package com.example.recetariomatoro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class IngredientSelectionActivity extends AppCompatActivity {

    ArrayList<String> selectedIngredients = new ArrayList<>();
    HashMap<String, String[]> ingredientCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_selection);

        ListView lvIngredients = findViewById(R.id.lv_ingredients);
        Button btnNext = findViewById(R.id.btn_next);

        // Obtener la categoría seleccionada
        String category = getIntent().getStringExtra("category");

        // Mapear categorías a ingredientes
        ingredientCategories = new HashMap<>();
        ingredientCategories.put("Bebidas", new String[]{"Agua", "Leche", "Café", "Té", "Jugo de naranja"});
        ingredientCategories.put("Postres", new String[]{"Harina", "Huevos", "Leche", "Chocolate", "Azúcar"});
        ingredientCategories.put("Ensaladas", new String[]{"Lechuga", "Tomate", "Zanahoria", "Pepino", "Aceitunas"});
        ingredientCategories.put("Mariscos", new String[]{"Camarones", "Pulpo", "Calamares", "Pescado", "Almejas"});
        ingredientCategories.put("Carnes", new String[]{"Pollo", "Carne de res", "Cerdo", "Cordero", "Pavo"});

        String[] ingredients = ingredientCategories.getOrDefault(category, new String[]{});

        // Adaptador para mostrar ingredientes
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, ingredients);
        lvIngredients.setAdapter(adapter);
        lvIngredients.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnNext.setOnClickListener(v -> {
            selectedIngredients.clear();
            for (int i = 0; i < lvIngredients.getCount(); i++) {
                if (lvIngredients.isItemChecked(i)) {
                    selectedIngredients.add(ingredients[i]);
                }
            }

            Intent intent = new Intent(IngredientSelectionActivity.this, AllergenSelectionActivity.class);
            intent.putStringArrayListExtra("selectedIngredients", selectedIngredients);
            startActivity(intent);
        });
    }
}
