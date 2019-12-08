package com.example.myrecipes.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.myrecipes.R;
import com.example.myrecipes.data.RecipeItem;

import org.w3c.dom.Text;


public class OneItemPage extends Fragment {
    public static final String TAG = "OneItemPage";

    private TextView recipeName;
    private TextView recipeDescription;
    private TextView recipeIngredients;
    private TextView recipeTime;
    private ImageView recipeImage;


    public interface OneItemPageDialogListener {
        void onRecipeItemCreated(RecipeItem newItem);

    }

    private OneItemPageDialogListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_page_item, container, false);

        TextView name = view.findViewById(R.id.RecipeName);
        TextView ingredients = view.findViewById(R.id.RecipeIngredients);
        TextView description = view.findViewById(R.id.RecipeDescription);
        TextView time = view.findViewById(R.id.RecipeTime);

        RecipeItem item = new RecipeItem();

        name.setText(item.getName());
        ingredients.setText(item.getIngredients());
        description.setText(item.getDescription());
        time.setText(item.getTime());

        return view;
    }


  /*  @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.one_page_item)
                .setView(getContentView())
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                            //listener.onRecipeItemCreated(getRecipeItem());

                    }
                })
                .create();
    }

    private RecipeItem getRecipeItem() {
        RecipeItem recipeItem = new RecipeItem();
        recipeItem.setName(nameEditText.getText().toString());
        recipeItem.setDescription(descriptionEditText.getText().toString());
        recipeItem.setIngredients(ingredientsEditText.getText().toString());
        recipeItem.setTime(timeEditText.getText().toString());
        return recipeItem;

    }*/


    private View getContentView() {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.one_page_item, null);
        recipeName= contentView.findViewById(R.id.RecipeName);
        recipeDescription = contentView.findViewById(R.id.RecipeDescription);
        recipeIngredients= contentView.findViewById(R.id.RecipeIngredients);
        recipeTime = contentView.findViewById(R.id.RecipeTime);
        recipeImage = contentView.findViewById(R.id.RecipeImage);


        return contentView;
    }
}

