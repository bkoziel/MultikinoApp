package pl.sanders.multikinoapp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import pl.sanders.multikinoapp.R;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

        private Context context;
        private List<Films> list;

        public FilmsAdapter(Context context, List<Films> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.row_film, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Films films = list.get(position);

            holder.filmName.setText(films.getName());
            holder.filmDescription.setText(films.getDescription());
            holder.filmGenre.setText(films.getGenre());
            holder.filmCountry.setText(films.getCountry());
            Picasso.get().load(films.getPhoto()).into(holder.filmPhoto);
            Uri uri = Uri.parse(films.getTrailer());

            final MediaController mediacontroller = new MediaController(this.context);
            mediacontroller.setAnchorView(holder.filmTrailer);


            holder.filmTrailer.setMediaController(mediacontroller);
            holder.filmTrailer.setVideoURI(uri);
            holder.filmTrailer.requestFocus();
            holder.filmTrailer.start();
            //Picasso.get().load(films.getTrailer()).into(holder.filmTrailer);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView filmName, filmDescription, filmGenre , filmCountry;
            public ImageView filmPhoto;
            public Button more;
            public RelativeLayout RL;
            public VideoView filmTrailer;
            public ViewHolder(View itemView) {
                super(itemView);
                RL = itemView.findViewById(R.id.RL);
                filmName = itemView.findViewById(R.id.filmName);
                filmDescription = itemView.findViewById(R.id.filmDescription);
                filmGenre = itemView.findViewById(R.id.filmGenre);
                filmCountry = itemView.findViewById(R.id.filmCountry);
                filmPhoto = itemView.findViewById(R.id.filmPhoto);
                filmTrailer = itemView.findViewById(R.id.filmTrailer);
                more = itemView.findViewById(R.id.filmMoreButton);

                    more.setOnClickListener(new View.OnClickListener() {
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
                    });
            }
        }

    }
