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

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context context;
    private List<Event> list;

    public EventAdapter(Context context, List<Event> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_event, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event event = list.get(position);

        holder.eventName.setText(event.getName());
        holder.eventDescription.setText(event.getDescription());
        Picasso.get().load(event.getPhoto()).into(holder.eventPhoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName, eventDescription;
        public ImageView eventPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            //RL = itemView.findViewById(R.id.RL);
            eventName = itemView.findViewById(R.id.eventName);
            eventDescription = itemView.findViewById(R.id.eventDescription);
            eventPhoto = itemView.findViewById(R.id.eventPhoto);

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
