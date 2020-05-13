package pl.sanders.multikinoapp.ui.cennik;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.sanders.multikinoapp.R;
import pl.sanders.multikinoapp.ui.info.InfoViewModel;

public class CennikFragment extends Fragment {

    private CennikViewModel cennikViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        cennikViewModel =
                ViewModelProviders.of(this).get(CennikViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cennik, container, false);
        final TextView textView = root.findViewById(R.id.text_cennik);
        cennikViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}
