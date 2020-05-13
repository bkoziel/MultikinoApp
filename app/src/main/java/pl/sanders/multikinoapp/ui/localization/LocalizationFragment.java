package pl.sanders.multikinoapp.ui.localization;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import pl.sanders.multikinoapp.MapActivity;
import pl.sanders.multikinoapp.R;

public class LocalizationFragment extends Fragment {

    private LocalizationViewModel localizationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        localizationViewModel =
                ViewModelProviders.of(this).get(LocalizationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_localization, container, false);
        Button localizationButton = root.findViewById(R.id.ButtonLocalization);
        localizationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(v.getContext(), MapActivity.class);
                startActivity(i);
            }
        });
        final TextView textView = root.findViewById(R.id.text_share);
        localizationViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}