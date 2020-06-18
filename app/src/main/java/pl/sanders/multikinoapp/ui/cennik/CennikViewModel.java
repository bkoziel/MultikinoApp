package pl.sanders.multikinoapp.ui.cennik;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CennikViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CennikViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("Aktualny cennik:");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
