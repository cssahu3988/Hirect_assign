package com.example.hirect_assign.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hirect_assign.R;
import com.example.hirect_assign.databinding.CrptoItemBinding;
import com.example.hirect_assign.databinding.Fragment2Binding;
import com.example.hirect_assign.pojo.Model1;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment implements OnChartValueSelectedListener {

    private Fragment2Binding binding;
    private ArrayList<Model1>list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_2, container, false);
        SetUpRecyclerView();
        SetUpGraph();
        return binding.getRoot();
    }

    private void SetUpGraph() {
        PieChart chart = binding.chart1;
        chart.setUsePercentValues(true);


        List <PieEntry>NoOfEmp = new ArrayList();

        NoOfEmp.add(new PieEntry(0.6f, "BTC"));
        NoOfEmp.add(new PieEntry(0.4f, "ETH"));
        ;
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "");

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        chart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.animateXY(500, 500);
        chart.highlightValue(null);
        chart.invalidate();
    }



    private void LoadData() {
        list.clear();
        Model1 m = new Model1("BTC","+1.6%", "$ 29,850.15", "1 BTC","",
                getActivity().getDrawable(R.drawable.bitcoin),getActivity().getDrawable(R.drawable.bit_coin),getActivity().getDrawable(R.drawable.bit_coin_),
                null, Color.parseColor("#F6543E"));
        Model1 m2 = new Model1("ETH","-0.82%", "$ 10,561.24", "1 ETH","",
                getActivity().getDrawable(R.drawable.etherium),getActivity().getDrawable(R.drawable.eth),getActivity().getDrawable(R.drawable.eth_),
                null, Color.parseColor("#6374C3"));
        Model1 m3 = new Model1("USDT","-2.10%", "$ 3,676.76", "1 LTC","",
                getActivity().getDrawable(R.drawable.tcoin),getActivity().getDrawable(R.drawable.usdt),getActivity().getDrawable(R.drawable.usdt_),
                null, Color.parseColor("#30E0A1"));
        Model1 m4 = new Model1("BNC","+0.27%", "$ 5,241.62", "1 BNC","",
                getActivity().getDrawable(R.drawable.bnc),getActivity().getDrawable(R.drawable.bnc2),getActivity().getDrawable(R.drawable.bnc2_),
                null, Color.parseColor("#F3BA2F"));
        Model1 m5 = new Model1("ICP","+0.27%", "$ 5,241.62", "1 ICP","",
                getActivity().getDrawable(R.drawable.infinity),getActivity().getDrawable(R.drawable.icp),getActivity().getDrawable(R.drawable.icp_),
                null, Color.parseColor("#B7217D"));


        list.add(m);
        list.add(m2);
        //list.add(m3);
        //list.add(m4);
        //list.add(m5);
    }

    private void SetUpRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        MyAdapter adapter = new MyAdapter();
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @NonNull
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            CrptoItemBinding binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.crpto_item,parent,false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
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