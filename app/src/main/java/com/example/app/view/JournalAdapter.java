package com.example.app.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.Journal;
import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder>{
    private List<Journal> mArrayListJournalData;
    //private ArrayList<Journal> mFilteredListMovieData;
    private Context mContext;

    public JournalAdapter(List<Journal> arrayList, Context context) {
        mArrayListJournalData = arrayList;
       // mFilteredListMovieData = arrayList;
        this.mContext = context;
    }

    @Override
    public JournalAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.journal_inflator, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JournalAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_id.setText(mArrayListJournalData.get(i).getId());
        viewHolder.tv_date.setText(mArrayListJournalData.get(i).getPublication_date());
        viewHolder.tv_articleType.setText(mArrayListJournalData.get(i).getArticle_type());
       // Converters converters = new Converters();
       // String abstractData = Converters.listToString(mArrayListJournalData.get(i).getAbstract_());
        viewHolder.tv_abstract.setText(mArrayListJournalData.get(i).getAbstract_().toString());

    }

    @Override
    public int getItemCount() {
        return mArrayListJournalData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_id,tv_date,tv_articleType,tv_abstract;
        public ViewHolder(View view) {
            super(view);
            tv_id = (TextView)view.findViewById(R.id.tv_id);
            tv_date = (TextView)view.findViewById(R.id.tv_publi_date);
            tv_articleType = (TextView)view.findViewById(R.id.tv_article_type);
            tv_abstract = (TextView)view.findViewById(R.id.tv_abstract);
        }
    }

}
