package pl.sanders.multikinoapp.ui.repertoire;

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

import pl.sanders.multikinoapp.Adapter.Films;
import pl.sanders.multikinoapp.R;
import pl.sanders.multikinoapp.Adapter.FilmsAdapter;

public class RepertoireFragment extends Fragment {

    private RecyclerView filmsRecycleView;
    private RecyclerView.Adapter adapter;
    private RepertoireViewModel repertoireViewModel;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Films> filmsList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        repertoireViewModel =
                ViewModelProviders.of(this).get(RepertoireViewModel.class);
        View root = inflater.inflate(R.layout.fragment_repertoire, container, false);
        final TextView textView = root.findViewById(R.id.text_repertoire);

        repertoireViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        /*
        // Create a new user with a first and last name
        Map<String, Object> film = new HashMap<>();
        film.put("description", "Historia");
        film.put("director", "Andre");
        film.put("genre", "Dramat");
        film.put("name", "Ania w ciemności");
        film.put("photo", "");
        film.put("played", true);


// Add a new document with a generated ID
        db.collection("Films")
                .add(film)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                       // Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error adding document", e);
                    }
                });
*/
        filmsList = new ArrayList<>();
        db.collection("films")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Films film;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                film = new Films();
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                               // textView.append(/*document.getId() + " => " + */document.getData().get("name") + "\n");
                                film.setName(document.getData().get("name").toString());
                                film.setDescription(document.getData().get("description").toString());
                                film.setPhoto(document.getData().get("photo").toString());
                                //film.setPlayed("true");
                                //film.setPlayed(document.getData().get("played").toString());
                                film.setTrailer(document.getData().get("trailer").toString());
                                film.setDirector(document.getData().get("director").toString());
                                film.setCountry(document.getData().get("country").toString());
                                film.setGenre(document.getData().get("genre").toString());
                                filmsList.add(film);
                            }
                            textView.append("\n");
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        adapter = new FilmsAdapter(getContext(), filmsList);
        filmsRecycleView = root.findViewById(R.id.recycleViewFilms);

        linearLayoutManager = new LinearLayoutManager(root.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(filmsRecycleView.getContext(), linearLayoutManager.getOrientation());

        filmsRecycleView.setHasFixedSize(false);
        filmsRecycleView.setLayoutManager(linearLayoutManager);
        filmsRecycleView.addItemDecoration(dividerItemDecoration);
        filmsRecycleView.setAdapter(adapter);
        return root;
    }
}