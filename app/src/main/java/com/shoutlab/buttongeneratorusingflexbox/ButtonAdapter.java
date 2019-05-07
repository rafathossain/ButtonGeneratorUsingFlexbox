package com.shoutlab.buttongeneratorusingflexbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {

    private Context mContext;

    private ArrayList<ButtonItems> buttonItems;

    ButtonAdapter(Context mContext, ArrayList<ButtonItems> buttonItems) {
        this.mContext = mContext;
        this.buttonItems = buttonItems;
    }

    @NonNull
    @Override
    public ButtonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.button_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonAdapter.ViewHolder viewHolder, int position) {
        final ButtonItems nbuttonItems = buttonItems.get(position);

        Button button;

        button = viewHolder.button;

        button.setText(nbuttonItems.getId());

        final String toast_msg = nbuttonItems.getId() + " Button is pressed";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,toast_msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return buttonItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        Button button;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.button_id);

        }
    }
}
