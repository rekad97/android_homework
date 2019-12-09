package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myrecipes.data.RecipeItem;

public class EditActivity extends AppCompatActivity {
    TextView recipeName;
    TextView recipeDescription;
    TextView recipeIngredients;
    TextView recipeTime;
    ImageView recipeImage;
RecipeItem recipeItem = new RecipeItem();
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
        String name = recipeName.getText().toString().trim();
        String ingredients = recipeIngredients.getText().toString().trim();
        String description = recipeDescription.getText().toString().trim();
        String time = recipeTime.getText().toString().trim();

        recipeItem.setName(name);
        recipeItem.setIngredients(ingredients);
        recipeItem.setDescription(description);
        recipeItem.setTime(time);

        recipeItem.save();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

}
