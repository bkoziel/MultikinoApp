package pl.sanders.multikinoapp.ui.repertoire;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import pl.sanders.multikinoapp.R;

public class RepertoireFragment extends Fragment {

    private RecyclerView filmsRecycleView;
    private RepertoireViewModel repertoireViewModel;
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
        db.collection("films")
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
        db.collection("films")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                            textView.append(/*document.getId() + " => " + */document.getData().get("name")+"\n");
                            }
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        return root;
    }
}