package pl.sanders.multikinoapp.ui.localization;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocalizationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LocalizationViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}