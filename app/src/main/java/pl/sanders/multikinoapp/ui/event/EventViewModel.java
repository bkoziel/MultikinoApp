package pl.sanders.multikinoapp.ui.event;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EventViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EventViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("Jakieś wydarzenia");
    }

    public LiveData<String> getText() {
        return mText;
    }
}