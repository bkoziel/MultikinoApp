package pl.sanders.multikinoapp.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.sanders.multikinoapp.Adapter.News;
import pl.sanders.multikinoapp.Adapter.NewsAdapter;
import pl.sanders.multikinoapp.R;

public class NewsFragment extends Fragment {


    private RecyclerView newsRecycleView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<News> newsList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private NewsViewModel newsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        newsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        newsList = new ArrayList<>();
        db.collection("news")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            News news;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                news = new News();

                                news.setName(document.getData().get("name").toString());
                                news.setDescription(document.getData().get("description").toString());
                                news.setDescription2(document.getData().get("description2").toString());
                                news.setPhoto(document.getData().get("photo").toString());
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
                                try {
                                    news.setDate(dateFormat.parse(document.getData().get("date").toString()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                newsList.add(news);
                            }
                            textView.append("\n");
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        adapter = new NewsAdapter(getContext(), newsList);
        newsRecycleView = root.findViewById(R.id.recyclerViewNews);

        linearLayoutManager = new LinearLayoutManager(root.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(newsRecycleView.getContext(), linearLayoutManager.getOrientation());

        newsRecycleView.setHasFixedSize(false);
        newsRecycleView.setLayoutManager(linearLayoutManager);
        newsRecycleView.addItemDecoration(dividerItemDecoration);
        newsRecycleView.setAdapter(adapter);


        return root;
    }
}