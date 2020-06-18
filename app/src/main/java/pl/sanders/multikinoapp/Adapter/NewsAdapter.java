package pl.sanders.multikinoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

import pl.sanders.multikinoapp.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> list;

    public NewsAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = list.get(position);

        holder.newsName.setText(news.getName());
        holder.newsDescription.setText(news.getDescription());
        holder.newsDescription.setText(news.getDescription());
        Picasso.get().load(news.getPhoto()).into(holder.newsPhoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView newsName, newsDescription;
        public ImageView newsPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            //RL = itemView.findViewById(R.id.RL);
            newsName = itemView.findViewById(R.id.newsName);
            newsDescription = itemView.findViewById(R.id.newsDescription);
            newsDescription = itemView.findViewById(R.id.newsDescription2);
            newsPhoto = itemView.findViewById(R.id.newsPhoto);

            //more = itemView.findViewById(R.id.filmMoreButton);

           /* more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(more.getText().equals("Więcej")) {

                        RL.getLayoutParams().height = RelativeLayout.LayoutParams.MATCH_PARENT;
                        RL.requestLayout();
                        more.setText("Mniej");
                        filmTrailer.setVisibility(View.VISIBLE);

                    }else{
                        RL.getLayoutParams().height = RelativeLayout.LayoutParams.WRAP_CONTENT;
                        RL.requestLayout();
                        more.setText("Więcej");
                        filmTrailer.setVisibility(View.INVISIBLE);
                    }


           //RL.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,400));
                    //Intent i;
                    //i = new Intent(v.getContext(), MapActivity.class);
                    //startActivity(i);
                }
            });*/
        }
    }

}
