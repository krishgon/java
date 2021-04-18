package com.krishapps.recyclerviewcommercial;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final Contact[] localContactsList;
    private TextView sNo_textView;
    private TextView phNo_textView;
    private TextView name_textView;

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);

        }

//        public TextView getTextView(){
//            return
//        }
    }

    public ContactAdapter(Contact[] contactsList){
        localContactsList = contactsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.context_box, viewGroup, false);

        sNo_textView = view.findViewById(R.id.sNo_textView);
        phNo_textView = view.findViewById(R.id.phNo_textView);
        name_textView = view.findViewById(R.id.name_textView);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position){

        sNo_textView.setText(localContactsList[position].getsNo());
        phNo_textView.setText(localContactsList[position].getPhoneNo());
        name_textView.setText(localContactsList[position].getName());

    }

    @Override
    public int getItemCount(){
        return localContactsList.length;
    }
}
