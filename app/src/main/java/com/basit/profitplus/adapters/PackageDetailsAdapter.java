package com.basit.profitplus.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basit.profitplus.R;
import com.basit.profitplus.models.PackagesDetails;
import com.basit.profitplus.ui.BuyNewPackageActivity;
import com.basit.profitplus.ui.ConfirmPackageActivity;

import java.util.ArrayList;


public class PackageDetailsAdapter extends RecyclerView.Adapter<PackageDetailsAdapter.MyHolder> {

    private ArrayList<PackagesDetails> packagesDetailsArrayList ;
    private Context context;

    public PackageDetailsAdapter(ArrayList<PackagesDetails> packagesDetailsArrayList, Context context) {
        this.packagesDetailsArrayList = packagesDetailsArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public PackageDetailsAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.packages_details_layout , parent , false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageDetailsAdapter.MyHolder holder, int position) {

        PackagesDetails packagesDetails = packagesDetailsArrayList.get(position);


        holder.textAmount.setText(packagesDetails.getPackageAmount());
        holder.textDurations.setText(packagesDetails.getPackageDurations());

        holder.textDescription.setText(packagesDetails.getPackageBonus());


        holder.itemView.setOnClickListener(v -> {


            Intent intent = new Intent(context, ConfirmPackageActivity.class);

            intent.putExtra("Amount" , packagesDetails.getPackageAmount());
            intent.putExtra("bonus" , packagesDetails.getPackageBonus());
            intent.putExtra("duration" , packagesDetails.getPackageDurations());

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return packagesDetailsArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        TextView textAmount, textDurations , textDescription ;
        ImageView btnNext;
        public MyHolder(@NonNull View itemView) {
            super(itemView);


            textAmount = itemView.findViewById(R.id.textAmount);


            textDurations = itemView.findViewById(R.id.textDurations);
            textDescription = itemView.findViewById(R.id.textBonus);
            btnNext = itemView.findViewById(R.id.btnNext);
        }
    }
}
