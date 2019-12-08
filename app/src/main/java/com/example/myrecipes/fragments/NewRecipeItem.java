package com.example.myrecipes.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import com.example.myrecipes.R;
import com.example.myrecipes.data.RecipeItem;


public class NewRecipeItem extends DialogFragment {
    public static final String TAG = "NewRecipeItem";

    private EditText nameEditText;
    private EditText descriptionEditText;
    private EditText ingredientsEditText;
    private EditText timeEditText;
    private Image image;


    public interface NewRecipeItemDialogListener {
        void onRecipeItemCreated(RecipeItem newItem);

    }

    private NewRecipeItemDialogListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity instanceof NewRecipeItemDialogListener) {
            listener = (NewRecipeItemDialogListener) activity;

        } else {
            throw new RuntimeException("Activity must implement the NewRecipeItemDialogListener interface!");
        }



    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.new_recipe_item)
                .setView(getContentView())
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(isValid()){
                            listener.onRecipeItemCreated(getRecipeItem());
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .create();
    }

    private RecipeItem getRecipeItem() {
        RecipeItem recipeItem = new RecipeItem();
        recipeItem.setName(nameEditText.getText().toString());
        recipeItem.setDescription(descriptionEditText.getText().toString());
        recipeItem.setIngredients(ingredientsEditText.getText().toString());
        recipeItem.setTime(timeEditText.getText().toString());
        return recipeItem;

    }

    private boolean isValid() {
        return nameEditText.getText().length() > 0;
    }

    private View getContentView() {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.new_recipe_item, null);
        nameEditText = contentView.findViewById(R.id.RecipeItemNameEditText);
        descriptionEditText = contentView.findViewById(R.id.RecipeItemDescriptionEditText);
        ingredientsEditText= contentView.findViewById(R.id.RecipeItemIngredientsEditText);
        timeEditText = contentView.findViewById(R.id.RecipeItemTimeEditText);


        return contentView;
    }
}

