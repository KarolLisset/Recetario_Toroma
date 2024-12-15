package com.example.recetariomatoro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_results);

        ListView lvRecipes = findViewById(R.id.lv_recipes);

        // Datos enviados desde la actividad anterior
        ArrayList<String> selectedIngredients = getIntent().getStringArrayListExtra("selectedIngredients");

        // Definición de recetas
        HashMap<String, Recipe> recipes = new HashMap<>();
        recipes.put("Ensalada César", new Recipe(
                List.of("Lechuga", "Pollo", "Queso", "Crutones", "Aderezo César"),
                List.of(
                        "1. Lava y corta la lechuga.",
                        "2. Cocina el pollo y córtalo en tiras.",
                        "3. Mezcla la lechuga, el pollo, el queso y los crutones.",
                        "4. Añade aderezo César al gusto."
                )
        ));

        recipes.put("Tacos de Pollo", new Recipe(
                List.of("Pollo", "Tortillas", "Cebolla", "Aguacate", "Salsa"),
                List.of(
                        "1. Cocina el pollo y córtalo en tiras.",
                        "2. Pica la cebolla y el aguacate.",
                        "3. Calienta las tortillas.",
                        "4. Rellena las tortillas con el pollo y los demás ingredientes.",
                        "5. Sirve con salsa al gusto."
                )
        ));

        recipes.put("Sopa de Tomate", new Recipe(
                List.of("Tomate", "Cebolla", "Ajo", "Aceite de oliva", "Caldo de pollo"),
                List.of(
                        "1. Saltea la cebolla y el ajo en aceite de oliva.",
                        "2. Añade los tomates cortados y cocina por 10 minutos.",
                        "3. Incorpora el caldo de pollo y cocina por 20 minutos.",
                        "4. Licúa la mezcla y sirve caliente."
                )
        ));

        recipes.put("Salteado de Brócoli y Zanahoria", new Recipe(
                List.of("Brócoli", "Zanahoria", "Ajo", "Aceite de oliva", "Salsa de soya"),
                List.of(
                        "1. Corta el brócoli y la zanahoria en trozos pequeños.",
                        "2. Saltea el ajo en aceite de oliva.",
                        "3. Añade el brócoli y la zanahoria, y cocina por 5 minutos.",
                        "4. Agrega salsa de soya al gusto y mezcla bien."
                )
        ));

        recipes.put("Puré de Papas", new Recipe(
                List.of("Papas", "Mantequilla", "Leche", "Sal"),
                List.of(
                        "1. Cocina las papas en agua hirviendo hasta que estén suaves.",
                        "2. Pela las papas y aplástalas con un tenedor o prensa.",
                        "3. Añade mantequilla, leche y sal al gusto.",
                        "4. Mezcla bien hasta obtener un puré suave."
                )
        ));

        recipes.put("Arroz con Verduras", new Recipe(
                List.of("Arroz", "Zanahoria", "Brócoli", "Cebolla", "Aceite de oliva"),
                List.of(
                        "1. Cocina el arroz según las instrucciones del paquete.",
                        "2. Corta las verduras en trozos pequeños.",
                        "3. Saltea las verduras en aceite de oliva.",
                        "4. Mezcla el arroz con las verduras y sirve."
                )
        ));

        recipes.put("Salmón al Horno", new Recipe(
                List.of("Salmón", "Limón", "Aceite de oliva", "Ajo", "Perejil"),
                List.of(
                        "1. Precalienta el horno a 200°C.",
                        "2. Coloca el salmón en una bandeja para hornear.",
                        "3. Rocía con aceite de oliva, jugo de limón, ajo picado y perejil.",
                        "4. Hornea durante 15-20 minutos."
                )
        ));

        recipes.put("Ensalada de Aguacate y Pollo", new Recipe(
                List.of("Aguacate", "Pollo", "Lechuga", "Tomate", "Aderezo al gusto"),
                List.of(
                        "1. Cocina el pollo y córtalo en trozos pequeños.",
                        "2. Corta el aguacate, la lechuga y el tomate.",
                        "3. Mezcla todos los ingredientes y añade aderezo al gusto."
                )
        ));

        recipes.put("Omelette de Champiñones", new Recipe(
                List.of("Huevo", "Champiñones", "Cebolla", "Aceite de oliva", "Queso"),
                List.of(
                        "1. Bate los huevos en un tazón.",
                        "2. Saltea los champiñones y la cebolla en aceite de oliva.",
                        "3. Vierte los huevos batidos y cocina a fuego lento.",
                        "4. Añade queso y dobla el omelette antes de servir."
                )
        ));

        recipes.put("Guacamole", new Recipe(
                List.of("Aguacate", "Cebolla", "Limón", "Tomate", "Sal"),
                List.of(
                        "1. Machaca el aguacate en un tazón.",
                        "2. Añade cebolla picada, tomate y jugo de limón.",
                        "3. Mezcla bien y sazona con sal al gusto."
                )
        ));
        recipes.put("Crema de Zanahoria", new Recipe(
                List.of("Zanahoria", "Cebolla", "Ajo", "Caldo de pollo", "Mantequilla"),
                List.of(
                        "1. Pela y corta las zanahorias en trozos pequeños.",
                        "2. Saltea la cebolla y el ajo en mantequilla.",
                        "3. Añade las zanahorias y el caldo de pollo.",
                        "4. Cocina hasta que las zanahorias estén blandas y licúa la mezcla.",
                        "5. Sirve caliente."
                )
        ));

        recipes.put("Pizza de Pollo y Champiñones", new Recipe(
                List.of("Masa de pizza", "Pollo", "Champiñones", "Queso", "Salsa de tomate"),
                List.of(
                        "1. Precalienta el horno a 200°C.",
                        "2. Extiende la masa de pizza y cúbrela con salsa de tomate.",
                        "3. Añade pollo cocido, champiñones y queso.",
                        "4. Hornea durante 15-20 minutos o hasta que el queso se derrita."
                )
        ));

        recipes.put("Frittata de Verduras", new Recipe(
                List.of("Huevo", "Brócoli", "Zanahoria", "Queso", "Aceite de oliva"),
                List.of(
                        "1. Bate los huevos en un tazón.",
                        "2. Cocina ligeramente el brócoli y la zanahoria.",
                        "3. Calienta aceite de oliva en una sartén.",
                        "4. Vierte la mezcla de huevo y añade las verduras y el queso.",
                        "5. Cocina a fuego lento hasta que esté firme."
                )
        ));

        recipes.put("Pollo al Limón", new Recipe(
                List.of("Pollo", "Limón", "Ajo", "Aceite de oliva", "Perejil"),
                List.of(
                        "1. Marina el pollo con jugo de limón, ajo picado y perejil.",
                        "2. Cocina en una sartén con aceite de oliva hasta que esté dorado.",
                        "3. Sirve caliente con una guarnición de tu elección."
                )
        ));

        recipes.put("Ensalada de Espinaca y Piña", new Recipe(
                List.of("Espinaca", "Piña", "Fresas", "Queso", "Vinagreta"),
                List.of(
                        "1. Lava las espinacas y córtalas en trozos grandes.",
                        "2. Agrega piña y fresas cortadas.",
                        "3. Añade queso y aliña con vinagreta al gusto."
                )
        ));

        recipes.put("Rollitos de Tortilla con Atún", new Recipe(
                List.of("Tortillas", "Atún", "Lechuga", "Queso crema"),
                List.of(
                        "1. Unta queso crema en las tortillas.",
                        "2. Coloca atún y lechuga encima.",
                        "3. Enrolla las tortillas y corta en trozos pequeños."
                )
        ));

        recipes.put("Brochetas de Pollo y Verduras", new Recipe(
                List.of("Pollo", "Pimientos", "Cebolla", "Champiñones", "Aceite de oliva"),
                List.of(
                        "1. Corta el pollo y las verduras en trozos pequeños.",
                        "2. Ensarta los ingredientes en palillos para brochetas.",
                        "3. Asa en una parrilla o sartén hasta que estén cocidos."
                )
        ));

        recipes.put("Caldo de Pollo", new Recipe(
                List.of("Pollo", "Zanahoria", "Papas", "Cebolla", "Caldo de pollo"),
                List.of(
                        "1. Cocina el pollo en agua con cebolla.",
                        "2. Añade las verduras cortadas en trozos.",
                        "3. Cocina a fuego lento hasta que las verduras estén suaves.",
                        "4. Sazona con sal y sirve caliente."
                )
        ));

        recipes.put("Arroz con Leche", new Recipe(
                List.of("Arroz", "Leche", "Azúcar", "Canela"),
                List.of(
                        "1. Cocina el arroz en agua hasta que esté suave.",
                        "2. Añade leche, azúcar y canela.",
                        "3. Cocina a fuego lento, revolviendo constantemente, hasta que espese.",
                        "4. Deja enfriar y sirve."
                )
        ));

        recipes.put("Ensalada de Frutas", new Recipe(
                List.of("Plátano", "Fresa", "Uvas", "Piña", "Yogurt"),
                List.of(
                        "1. Corta todas las frutas en trozos pequeños.",
                        "2. Mezcla las frutas en un tazón.",
                        "3. Añade yogurt y mezcla bien.",
                        "4. Sirve frío."
                )
        ));
        recipes.put("Pasta Alfredo con Pollo", new Recipe(
                List.of("Pasta", "Pollo", "Crema", "Queso parmesano", "Ajo"),
                List.of(
                        "1. Cocina la pasta según las instrucciones del paquete.",
                        "2. Saltea el pollo en una sartén con ajo.",
                        "3. Añade crema y queso parmesano.",
                        "4. Mezcla con la pasta cocida y sirve caliente."
                )
        ));

        recipes.put("Wraps de Lechuga y Pollo", new Recipe(
                List.of("Lechuga", "Pollo", "Zanahoria", "Salsa de soya"),
                List.of(
                        "1. Cocina el pollo y desmenúzalo.",
                        "2. Coloca el pollo y zanahorias ralladas dentro de las hojas de lechuga.",
                        "3. Aliña con salsa de soya y enrolla la lechuga."
                )
        ));

        recipes.put("Tacos de Salmón y Aguacate", new Recipe(
                List.of("Salmón", "Aguacate", "Tortillas", "Cebolla", "Limón"),
                List.of(
                        "1. Cocina el salmón en una sartén.",
                        "2. Coloca el salmón desmenuzado en las tortillas.",
                        "3. Añade aguacate, cebolla y un chorrito de limón."
                )
        ));

        recipes.put("Sopa de Brócoli", new Recipe(
                List.of("Brócoli", "Crema", "Cebolla", "Caldo de pollo", "Queso cheddar"),
                List.of(
                        "1. Cocina el brócoli en caldo de pollo hasta que esté blando.",
                        "2. Licúa el brócoli con crema y queso cheddar.",
                        "3. Cocina a fuego lento hasta que espese."
                )
        ));

        recipes.put("Salteado de Verduras y Pollo", new Recipe(
                List.of("Pollo", "Brócoli", "Zanahoria", "Cebolla", "Salsa de soya"),
                List.of(
                        "1. Corta el pollo y las verduras en trozos pequeños.",
                        "2. Saltea el pollo hasta que esté cocido.",
                        "3. Añade las verduras y la salsa de soya.",
                        "4. Cocina hasta que las verduras estén tiernas."
                )
        ));

        recipes.put("Ensalada de Papas y Zanahorias", new Recipe(
                List.of("Papas", "Zanahorias", "Huevos", "Mayonesa"),
                List.of(
                        "1. Cocina las papas y zanahorias hasta que estén suaves.",
                        "2. Cocina los huevos y córtalos en trozos pequeños.",
                        "3. Mezcla todo con mayonesa y refrigera antes de servir."
                )
        ));

        recipes.put("Nuggets de Pollo Caseros", new Recipe(
                List.of("Pollo", "Huevo", "Pan rallado", "Harina"),
                List.of(
                        "1. Corta el pollo en trozos pequeños.",
                        "2. Reboza en harina, huevo y pan rallado.",
                        "3. Fríe en aceite caliente hasta que estén dorados."
                )
        ));

        recipes.put("Salmón Teriyaki", new Recipe(
                List.of("Salmón", "Salsa teriyaki", "Ajo", "Jengibre"),
                List.of(
                        "1. Marina el salmón en salsa teriyaki, ajo y jengibre.",
                        "2. Cocina en una sartén a fuego medio hasta que esté dorado.",
                        "3. Sirve con arroz blanco."
                )
        ));

        recipes.put("Tortilla Española", new Recipe(
                List.of("Huevos", "Papas", "Cebolla", "Aceite de oliva"),
                List.of(
                        "1. Pela y corta las papas en rodajas finas.",
                        "2. Cocina las papas y cebolla en aceite de oliva hasta que estén blandas.",
                        "3. Bate los huevos y mézclalos con las papas y la cebolla.",
                        "4. Cocina en una sartén hasta que esté firme."
                )
        ));

        recipes.put("Pollo al Curry", new Recipe(
                List.of("Pollo", "Curry en polvo", "Leche de coco", "Cebolla"),
                List.of(
                        "1. Saltea la cebolla en una sartén.",
                        "2. Añade el pollo y el curry en polvo.",
                        "3. Incorpora la leche de coco y cocina a fuego lento hasta que el pollo esté cocido."
                )
        ));

        recipes.put("Pizza de Vegetales", new Recipe(
                List.of("Masa de pizza", "Champiñones", "Brócoli", "Queso", "Salsa de tomate"),
                List.of(
                        "1. Extiende la masa de pizza y cúbrela con salsa de tomate.",
                        "2. Añade los champiñones, brócoli y queso.",
                        "3. Hornea a 200°C hasta que el queso esté dorado."
                )
        ));

        recipes.put("Tacos de Atún", new Recipe(
                List.of("Tortillas", "Atún", "Lechuga", "Aguacate"),
                List.of(
                        "1. Mezcla el atún con aguacate.",
                        "2. Coloca la mezcla en las tortillas y añade lechuga.",
                        "3. Sirve con limón si lo deseas."
                )
        ));

        recipes.put("Huevos a la Mexicana", new Recipe(
                List.of("Huevos", "Tomate", "Cebolla", "Chile"),
                List.of(
                        "1. Pica el tomate, la cebolla y el chile.",
                        "2. Saltea los ingredientes en una sartén.",
                        "3. Añade los huevos batidos y cocina hasta que estén listos."
                )
        ));

        recipes.put("Smoothie de Aguacate", new Recipe(
                List.of("Aguacate", "Yogurt", "Leche", "Miel"),
                List.of(
                        "1. Mezcla todos los ingredientes en una licuadora.",
                        "2. Licúa hasta obtener una consistencia suave.",
                        "3. Sirve frío."
                )
        ));

        recipes.put("Crepas de Champiñones", new Recipe(
                List.of("Harina", "Leche", "Huevos", "Champiñones", "Queso"),
                List.of(
                        "1. Prepara las crepas mezclando harina, leche y huevos.",
                        "2. Cocina los champiñones en una sartén.",
                        "3. Rellena las crepas con champiñones y queso."
                )
        ));

        recipes.put("Ensalada de Brócoli y Nueces", new Recipe(
                List.of("Brócoli", "Nueces", "Yogurt", "Limón"),
                List.of(
                        "1. Cocina el brócoli al vapor.",
                        "2. Mezcla con nueces y aliña con yogurt y jugo de limón.",
                        "3. Refrigera antes de servir."
                )
        ));

        recipes.put("Pasta con Espinaca y Queso", new Recipe(
                List.of("Pasta", "Espinaca", "Queso crema", "Ajo"),
                List.of(
                        "1. Cocina la pasta según las instrucciones del paquete.",
                        "2. Saltea la espinaca con ajo.",
                        "3. Mezcla con queso crema y combina con la pasta."
                )
        ));

        recipes.put("Muffins de Zanahoria", new Recipe(
                List.of("Zanahoria", "Harina", "Huevos", "Azúcar"),
                List.of(
                        "1. Ralla las zanahorias.",
                        "2. Mezcla con harina, huevos y azúcar.",
                        "3. Hornea a 180°C por 20 minutos."
                )
        ));

        recipes.put("Sopa de Tomate y Albahaca", new Recipe(
                List.of("Tomates", "Albahaca", "Ajo", "Caldo de verduras"),
                List.of(
                        "1. Cocina los tomates en caldo de verduras.",
                        "2. Añade ajo y albahaca.",
                        "3. Licúa y sirve caliente."
                )
        ));
        recipes.put("Hamburguesas de Pollo", new Recipe(
                List.of("Pollo molido", "Pan de hamburguesa", "Lechuga", "Queso", "Tomate"),
                List.of(
                        "1. Mezcla el pollo molido con especias y forma las hamburguesas.",
                        "2. Cocina en una sartén o parrilla.",
                        "3. Arma las hamburguesas con lechuga, queso y tomate."
                )
        ));

        recipes.put("Batido de Fresa y Plátano", new Recipe(
                List.of("Fresas", "Plátano", "Leche", "Yogurt"),
                List.of(
                        "1. Coloca las fresas, plátano, leche y yogurt en una licuadora.",
                        "2. Licúa hasta que quede suave.",
                        "3. Sirve frío."
                )
        ));

        recipes.put("Ensalada de Pollo y Piña", new Recipe(
                List.of("Pollo", "Piña", "Lechuga", "Mayonesa"),
                List.of(
                        "1. Cocina el pollo y córtalo en trozos pequeños.",
                        "2. Mezcla con trozos de piña, lechuga y mayonesa.",
                        "3. Refrigera antes de servir."
                )
        ));

        recipes.put("Brócoli Gratinado", new Recipe(
                List.of("Brócoli", "Queso", "Crema", "Mantequilla"),
                List.of(
                        "1. Cocina el brócoli al vapor.",
                        "2. Coloca el brócoli en un recipiente para horno.",
                        "3. Cubre con crema, queso y un poco de mantequilla.",
                        "4. Hornea a 200°C hasta que el queso se derrita."
                )
        ));

        recipes.put("Papas a la Francesa con Ajo", new Recipe(
                List.of("Papas", "Ajo", "Aceite de oliva"),
                List.of(
                        "1. Corta las papas en tiras y sazónalas con ajo y aceite de oliva.",
                        "2. Hornea a 200°C hasta que estén doradas.",
                        "3. Sirve como acompañamiento."
                )
        ));

        recipes.put("Tostadas de Aguacate y Atún", new Recipe(
                List.of("Tostadas", "Aguacate", "Atún", "Cebolla", "Limón"),
                List.of(
                        "1. Unta aguacate sobre las tostadas.",
                        "2. Coloca el atún encima y añade cebolla picada.",
                        "3. Exprime un poco de limón antes de servir."
                )
        ));

        recipes.put("Pollo al Horno con Limón", new Recipe(
                List.of("Pechuga de pollo", "Limón", "Ajo", "Aceite de oliva"),
                List.of(
                        "1. Marina el pollo con jugo de limón, ajo y aceite de oliva.",
                        "2. Hornea a 200°C durante 25 minutos.",
                        "3. Sirve con una guarnición de tu elección."
                )
        ));

        recipes.put("Frittata de Vegetales", new Recipe(
                List.of("Huevos", "Brócoli", "Champiñones", "Queso"),
                List.of(
                        "1. Bate los huevos y mézclalos con los vegetales.",
                        "2. Cocina en una sartén a fuego bajo hasta que esté firme.",
                        "3. Añade queso encima y sirve."
                )
        ));

        recipes.put("Ceviche de Salmón", new Recipe(
                List.of("Salmón", "Limón", "Cebolla", "Aguacate"),
                List.of(
                        "1. Corta el salmón en cubos pequeños.",
                        "2. Marina con jugo de limón y añade cebolla picada.",
                        "3. Incorpora trozos de aguacate antes de servir."
                )
        ));

        recipes.put("Empanadas de Pollo", new Recipe(
                List.of("Pollo", "Masa para empanadas", "Cebolla", "Queso"),
                List.of(
                        "1. Cocina el pollo y desmenúzalo.",
                        "2. Rellena la masa con pollo, cebolla y queso.",
                        "3. Cierra las empanadas y hornea a 180°C hasta que estén doradas."
                )
        ));

        recipes.put("Ensalada de Fresas y Espinacas", new Recipe(
                List.of("Fresas", "Espinacas", "Nueces", "Queso de cabra"),
                List.of(
                        "1. Mezcla las fresas en rodajas con las espinacas.",
                        "2. Añade nueces y queso de cabra desmenuzado.",
                        "3. Aliña con vinagre balsámico."
                )
        ));

        recipes.put("Salmón a la Parrilla", new Recipe(
                List.of("Salmón", "Ajo", "Aceite de oliva", "Limón"),
                List.of(
                        "1. Marina el salmón con ajo, aceite de oliva y limón.",
                        "2. Cocina en una parrilla a fuego medio.",
                        "3. Sirve con una guarnición de vegetales."
                )
        ));

        recipes.put("Tacos de Champiñones", new Recipe(
                List.of("Champiñones", "Tortillas", "Cebolla", "Ajo"),
                List.of(
                        "1. Cocina los champiñones con ajo y cebolla.",
                        "2. Coloca los champiñones en las tortillas.",
                        "3. Sirve con limón y salsa al gusto."
                )
        ));

        recipes.put("Puré de Papas con Queso", new Recipe(
                List.of("Papas", "Queso", "Mantequilla", "Leche"),
                List.of(
                        "1. Cocina las papas y haz un puré.",
                        "2. Añade queso, mantequilla y leche.",
                        "3. Mezcla bien y sirve caliente."
                )
        ));

        recipes.put("Omelette de Espinaca y Queso", new Recipe(
                List.of("Huevos", "Espinaca", "Queso"),
                List.of(
                        "1. Bate los huevos y cocina en una sartén.",
                        "2. Añade espinaca y queso antes de doblar el omelette.",
                        "3. Cocina hasta que el queso se derrita."
                )
        ));

        recipes.put("Arroz Frito con Pollo", new Recipe(
                List.of("Arroz", "Pollo", "Cebolla", "Zanahoria", "Salsa de soya"),
                List.of(
                        "1. Cocina el pollo en trozos pequeños.",
                        "2. Saltea el arroz con cebolla, zanahoria y salsa de soya.",
                        "3. Mezcla el pollo con el arroz antes de servir."
                )
        ));

        recipes.put("Batido de Uvas y Yogurt", new Recipe(
                List.of("Uvas", "Yogurt", "Leche", "Miel"),
                List.of(
                        "1. Mezcla las uvas, yogurt, leche y miel en una licuadora.",
                        "2. Licúa hasta que quede suave.",
                        "3. Sirve frío."
                )
        ));

        recipes.put("Tarta de Manzana y Canela", new Recipe(
                List.of("Masa para tarta", "Manzana", "Canela", "Azúcar"),
                List.of(
                        "1. Coloca rodajas de manzana sobre la masa.",
                        "2. Espolvorea con canela y azúcar.",
                        "3. Hornea a 180°C por 25 minutos."
                )
        ));

        recipes.put("Brochetas de Pollo y Verduras", new Recipe(
                List.of("Pollo", "Pimientos", "Cebolla", "Calabacín"),
                List.of(
                        "1. Ensarta trozos de pollo y verduras en palillos.",
                        "2. Cocina en una parrilla o sartén.",
                        "3. Sirve con una salsa al gusto."
                )
        ));

        recipes.put("Crema de Zanahoria", new Recipe(
                List.of("Zanahoria", "Cebolla", "Crema", "Caldo de verduras"),
                List.of(
                        "1. Cocina las zanahorias y la cebolla en caldo de verduras.",
                        "2. Licúa los ingredientes y añade crema.",
                        "3. Sirve caliente con pan tostado."
                )
        ));


        // Filtrar recetas basadas en los ingredientes seleccionados
        ArrayList<String> filteredRecipes = new ArrayList<>();
        for (String recipeName : recipes.keySet()) {
            Recipe recipe = recipes.get(recipeName);
            if (selectedIngredients.stream().anyMatch(recipe.ingredients::contains)) {
                filteredRecipes.add(recipeName);
            }
        }

        // Si no se encuentran recetas, mostrar un mensaje
        if (filteredRecipes.isEmpty()) {
            filteredRecipes.add("No se encontraron recetas con los ingredientes seleccionados.");
        }

        // Mostrar las recetas filtradas
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredRecipes);
        lvRecipes.setAdapter(adapter);

        // Al hacer clic en una receta, abrir detalles
        lvRecipes.setOnItemClickListener((parent, view, position, id) -> {
            String recipeName = filteredRecipes.get(position);
            if (recipes.containsKey(recipeName)) {
                Recipe selectedRecipe = recipes.get(recipeName);

                Intent intent = new Intent(RecipeResultsActivity.this, RecipeDetailActivity.class);
                intent.putExtra("recipeName", recipeName);
                intent.putStringArrayListExtra("recipeIngredients", new ArrayList<>(selectedRecipe.ingredients));
                intent.putStringArrayListExtra("recipeSteps", new ArrayList<>(selectedRecipe.steps));
                startActivity(intent);
            }
        });
    }

    // Clase interna para representar una receta
    private static class Recipe {
        List<String> ingredients;
        List<String> steps;

        Recipe(List<String> ingredients, List<String> steps) {
            this.ingredients = ingredients;
            this.steps = steps;
        }
    }
}
