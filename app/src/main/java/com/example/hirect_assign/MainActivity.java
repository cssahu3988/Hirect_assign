package com.example.hirect_assign;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hirect_assign.databinding.ActivityMainBinding;
import com.example.hirect_assign.databinding.CrptoItemBinding;
import com.example.hirect_assign.pojo.Model1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Model1> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoadData();
        SetUpRecyclerView();
    }

    private void LoadData() {
        Model1 m = new Model1("BTC","+1.6%", "$ 29,850.15", "1 BTC","",
                getDrawable(R.drawable.bitcoin),getDrawable(R.drawable.bit_coin),getDrawable(R.drawable.bit_coin_),
                null, Color.parseColor("#F6543E"));
        Model1 m2 = new Model1("ETH","-0.82%", "$ 10,561.24", "1 ETH","",
                getDrawable(R.drawable.etherium),getDrawable(R.drawable.eth),getDrawable(R.drawable.eth_),
                null, Color.parseColor("#6374C3"));
        Model1 m3 = new Model1("USDT","-2.10%", "$ 3,676.76", "1 LTC","",
                getDrawable(R.drawable.tcoin),getDrawable(R.drawable.usdt),getDrawable(R.drawable.usdt_),
                null, Color.parseColor("#30E0A1"));
        Model1 m4 = new Model1("BNC","+0.27%", "$ 5,241.62", "1 BNC","",
                getDrawable(R.drawable.bnc),getDrawable(R.drawable.bnc2),getDrawable(R.drawable.bnc2_),
                null, Color.parseColor("#F3BA2F"));
        Model1 m5 = new Model1("ICP","+0.27%", "$ 5,241.62", "1 ICP","",
                getDrawable(R.drawable.infinity),getDrawable(R.drawable.icp),getDrawable(R.drawable.icp_),
                null, Color.parseColor("#B7217D"));


        list.add(m);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    }

    private void SetUpRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        MyAdapter adapter = new MyAdapter();
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            CrptoItemBinding binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.crpto_item,parent,false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.binding.setModel(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            CrptoItemBinding binding;
            public ViewHolder(@NonNull CrptoItemBinding itemBinding) {
                super(itemBinding.getRoot());
                this.binding = itemBinding;
            }
        }
    }

}