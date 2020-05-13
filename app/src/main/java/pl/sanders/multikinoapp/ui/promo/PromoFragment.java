package pl.sanders.multikinoapp.ui.promo;

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

import pl.sanders.multikinoapp.R;

public class PromoFragment extends Fragment {

    private PromoViewModel promoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        promoViewModel =
                ViewModelProviders.of(this).get(PromoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_promo, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        promoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}