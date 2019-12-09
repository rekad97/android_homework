package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    TextView recipeName;
    TextView recipeDescription;
    TextView recipeIngredients;
    TextView recipeTime;
    ImageView recipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        recipeName = findViewById(R.id.RecipeEditName);
        recipeDescription = findViewById(R.id.RecipeEditDescription);
        recipeIngredients = findViewById((R.id.RecipeEditIngredients));
        recipeTime = findViewById(R.id.RecipeEditTime);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            recipeName.setText(bundle.getString("editName"));
            recipeDescription.setText(bundle.getString("editDescription"));
            recipeIngredients.setText(bundle.getString("editIngredients"));
            recipeTime.setText(bundle.getString("editTime"));
        }
    }
    public void UpdateRecipe(View view){

    }
}
