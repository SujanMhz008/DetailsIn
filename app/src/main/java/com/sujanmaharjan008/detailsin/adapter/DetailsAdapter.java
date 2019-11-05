package com.sujanmaharjan008.detailsin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sujanmaharjan008.detailsin.R;
import com.sujanmaharjan008.detailsin.model.Details;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {
    Context context;
    List<Details> detailsList;

    public DetailsAdapter(Context context, List<Details> detailsList) {
        this.context = context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_details, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        final Details details = detailsList.get(position);
        holder.imgCircle.setImageResource(details.getImageId());
        holder.txvName.setText(details.getName());
        holder.txvAge.setText(details.getAge());
        holder.txvGender.setText(details.getGender());
        holder.imgDelete.setImageResource(details.getDeleteId());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgCircle;
        TextView txvName, txvAge, txvGender;
        ImageView imgDelete;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCircle = itemView.findViewById(R.id.imgCircle);
            txvName = itemView.findViewById(R.id.txtName);
            txvAge = itemView.findViewById(R.id.txtAge);
            txvGender = itemView.findViewById(R.id.txtGender);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
