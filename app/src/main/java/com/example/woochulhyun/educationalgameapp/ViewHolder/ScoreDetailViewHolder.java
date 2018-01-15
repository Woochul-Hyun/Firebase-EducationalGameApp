package com.example.woochulhyun.educationalgameapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.woochulhyun.educationalgameapp.R;

/**
 * Created by WOOCHUL HYUN on 2018-01-15.
 */

public class ScoreDetailViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_name, txt_score;

    public ScoreDetailViewHolder(View itemView) {
        super(itemView);

        txt_name = (TextView)itemView.findViewById(R.id.txt_name);
        txt_score = (TextView)itemView.findViewById(R.id.txt_score);
    }
}
