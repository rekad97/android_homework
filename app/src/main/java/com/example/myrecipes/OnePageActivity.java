package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myrecipes.R;

public class OnePageActivity extends AppCompatActivity {

   TextView recipeName;
     TextView recipeDescription;
    TextView recipeIngredients;
    TextView recipeTime;
     ImageView recipeImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_page);

        recipeName = findViewById(R.id.RecipeName);
        recipeDescription = findViewById(R.id.RecipeDescription);
        recipeIngredients = findViewById((R.id.RecipeIngredients));
        recipeTime = findViewById(R.id.RecipeTime);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            recipeName.setText(bundle.getString("Name"));
            recipeIngredients.setText(bundle.getString("Ingredients"));
            recipeDescription.setText(bundle.getString("Description"));
            recipeTime.setText(bundle.getString("Time"));
        }


    }
}
