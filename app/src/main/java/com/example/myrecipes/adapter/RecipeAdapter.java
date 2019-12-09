package com.example.myrecipes.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myrecipes.OnePageActivity;
import com.example.myrecipes.R;
import com.example.myrecipes.data.RecipeItem;


import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(RecipeItem item);
    }

    private final List<RecipeItem> items;
    Dialog onePage;
    Context context;
    RecipeItem item;
    public RecipeItemClickListener listener;


    public RecipeAdapter(Context context, RecipeItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        items = new ArrayList<>();


    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe_list, parent, false);
        RecipeViewHolder holder = new RecipeViewHolder(itemView, listener);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final RecipeViewHolder holder, int position) {

        holder.nameTextView.setText(items.get(position).getName());
        holder.bind(items.get(position), listener);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OnePageActivity.class);
                intent.putExtra("Name", items.get(holder.getAdapterPosition()).getName());
                intent.putExtra("Ingredients", items.get(holder.getAdapterPosition()).getIngredients());
                intent.putExtra("Description", items.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Time", items.get(holder.getAdapterPosition()).getTime());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface RecipeItemClickListener {
        void onItemRemoved(RecipeItem toRemove);

        void onItemClick(int position);

    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView iconImageView;
        TextView nameTextView;
        TextView ingredientsTextView;
        TextView descriptionTextView;
        TextView timeTextView;
        ImageButton removeButton;
        ImageButton editButton;
        public RecipeItemClickListener listener;

        RecipeViewHolder(View itemView, RecipeItemClickListener listener) {
            super(itemView);

            iconImageView = itemView.findViewById(R.id.RecipeItemIconImageView);
            nameTextView = itemView.findViewById(R.id.RecipeNameInList);
            ingredientsTextView = itemView.findViewById(R.id.RecipeIngredients);
            descriptionTextView = itemView.findViewById(R.id.RecipeDescription);
            timeTextView = itemView.findViewById(R.id.RecipeTime);
            removeButton = itemView.findViewById(R.id.RecipeItemRemoveButton);

            itemView.setOnClickListener(this);
            this.listener = listener;

        }

        public void bind(final RecipeItem recipeItem, final RecipeItemClickListener listener) {
            nameTextView.setText(recipeItem.getName());

            itemView.setOnClickListener(this);


            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(getLayoutPosition());
                }
            });


        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());

        }
    }


    public void addItem(RecipeItem item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void update(List<RecipeItem> recipes) {
        items.clear();
        items.addAll(recipes);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        RecipeItem toRemove = items.remove(position);
        listener.onItemRemoved(toRemove);

    }

    public void changeItem(int position) {
     /*   RecipeItem toChange = items.get(position);
        listener.onItemChanged(toChange);*/

    }

}
