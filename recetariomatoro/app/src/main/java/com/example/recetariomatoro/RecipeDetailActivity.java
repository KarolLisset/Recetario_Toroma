package com.example.recetariomatoro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Referencias a los elementos del diseño
        TextView tvRecipeName = findViewById(R.id.tv_recipe_name);
        TextView tvRecipeIngredients = findViewById(R.id.tv_recipe_ingredients);
        TextView tvRecipeSteps = findViewById(R.id.tv_recipe_steps);
        Button btnReturnToMain = findViewById(R.id.btn_return_to_main);
        Button btnExit = findViewById(R.id.btn_exit);

        // Recuperar los datos enviados desde RecipeResultsActivity
        String recipeName = getIntent().getStringExtra("recipeName");
        ArrayList<String> recipeIngredients = getIntent().getStringArrayListExtra("recipeIngredients");
        ArrayList<String> recipeSteps = getIntent().getStringArrayListExtra("recipeSteps");

        // Mostrar los datos de la receta
        if (recipeName != null) {
            tvRecipeName.setText(recipeName);
        }

        if (recipeIngredients != null) {
            StringBuilder ingredientsBuilder = new StringBuilder("Ingredientes:\n");
            for (String ingredient : recipeIngredients) {
                ingredientsBuilder.append("- ").append(ingredient).append("\n");
            }
            tvRecipeIngredients.setText(ingredientsBuilder.toString());
        }

        if (recipeSteps != null) {
            StringBuilder stepsBuilder = new StringBuilder("Pasos:\n");
            for (String step : recipeSteps) {
                stepsBuilder.append(step).append("\n");
            }
            tvRecipeSteps.setText(stepsBuilder.toString());
        }

        // Configurar botón para regresar al menú principal
        btnReturnToMain.setOnClickListener(v -> {
            Intent intent = new Intent(RecipeDetailActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        // Configurar botón para salir de la aplicación
        btnExit.setOnClickListener(v -> finishAffinity());
    }
}
