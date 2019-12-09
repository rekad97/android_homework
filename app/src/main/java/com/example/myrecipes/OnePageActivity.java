package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myrecipes.R;
import com.example.myrecipes.data.RecipeItem;

public class OnePageActivity extends AppCompatActivity {

    TextView recipeName;
    TextView recipeDescription;
    TextView recipeIngredients;
    TextView recipeTime;
    ImageView recipeImage;
    RecipeItem recipeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_page);

        recipeName = findViewById(R.id.RecipeName);
        recipeDescription = findViewById(R.id.RecipeDescription);
        recipeIngredients = findViewById((R.id.RecipeIngredients));
        recipeTime = findViewById(R.id.RecipeTime);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            recipeName.setText(bundle.getString("Name"));
            recipeIngredients.setText(bundle.getString("Ingredients"));
            recipeDescription.setText(bundle.getString("Description"));
            recipeTime.setText(bundle.getString("Time"));
        }


    }

    public void EditRecipe(View view) {
        startActivity(new Intent(getApplicationContext(), EditActivity.class)
                .putExtra("editName", recipeName.getText().toString())
                .putExtra("editIngredients", recipeIngredients.getText().toString())
                .putExtra("editDescription", recipeDescription.getText().toString())
                .putExtra("editTime", recipeTime.getText().toString()));

    }



}
