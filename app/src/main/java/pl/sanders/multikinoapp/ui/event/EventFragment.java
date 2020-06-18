package pl.sanders.multikinoapp.ui.event;

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

import java.util.ArrayList;
import java.util.List;

import pl.sanders.multikinoapp.Adapter.Event;
import pl.sanders.multikinoapp.Adapter.EventAdapter;
import pl.sanders.multikinoapp.R;

public class EventFragment extends Fragment {


    private RecyclerView eventRecycleView;
    private RecyclerView.Adapter adapter;
    private EventViewModel eventViewModel;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Event> eventList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eventViewModel =
                ViewModelProviders.of(this).get(EventViewModel.class);
        View root = inflater.inflate(R.layout.fragment_event, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        eventViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        eventList = new ArrayList<>();
        db.collection("events")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Event event;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                event = new Event();

                                event.setName(document.getData().get("name").toString());
                                event.setDescription(document.getData().get("description").toString());
                                event.setPhoto(document.getData().get("photo").toString());

                                eventList.add(event);
                            }
                            textView.append("\n");
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        adapter = new EventAdapter(getContext(), eventList);
        eventRecycleView = root.findViewById(R.id.recyclerViewEvent);

        linearLayoutManager = new LinearLayoutManager(root.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(eventRecycleView.getContext(), linearLayoutManager.getOrientation());

        eventRecycleView.setHasFixedSize(false);
        eventRecycleView.setLayoutManager(linearLayoutManager);
        eventRecycleView.addItemDecoration(dividerItemDecoration);
        eventRecycleView.setAdapter(adapter);

        return root;
    }
}