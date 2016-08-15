package io.toru.retrofitandmvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.toru.retrofitandmvp.R;
import io.toru.retrofitandmvp.model.Question;

/**
 * Created by toru on 2016. 8. 15..
 */
public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private List<Question> questionList;

    public MainAdapter(List<Question> questionList) {
        this.questionList = questionList;
    }

    // initiate view
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);
        return new MainViewHolder(itemView);
    }

    // bind and update view
    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Question question = questionList.get(position);
        holder.updateView(question);
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}