package com.example.myrecipes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.myrecipes.adapter.RecipeAdapter;
import com.example.myrecipes.data.RecipeItem;
import com.example.myrecipes.fragments.NewRecipeItem;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.orm.SugarContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements   NewRecipeItem.NewRecipeItemDialogListener, RecipeAdapter.RecipeItemClickListener {

    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    public static final String TAG = "MainActivityPage";
    List<RecipeItem> recipes;
    RecipeItem recipeItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //r ecyclerView = (RecyclerView)findViewById(R.id.MainRecyclerView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NewRecipeItem().show(getSupportFragmentManager(), NewRecipeItem.TAG);
            }
        });




        initRecyclerView();
        for(RecipeItem recipeItem:RecipeItem.listAll(RecipeItem.class)){
            adapter.addItem(recipeItem);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.MainRecyclerView);
        adapter = new RecipeAdapter(this,(RecipeAdapter.RecipeItemClickListener)this);
        loadItemsInBackground();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadItemsInBackground() {

    }
    @Override
    public void onItemClick(int position) {

    }


    public void onItemChanged(final RecipeItem item) {

    }

    @Override
    public void onRecipeItemCreated(final RecipeItem newItem) {
        adapter.addItem(newItem);
        newItem.save();
    }

    @Override
    public void onItemRemoved(final RecipeItem item) {
        item.delete();
        adapter.notifyDataSetChanged();
    }
}
