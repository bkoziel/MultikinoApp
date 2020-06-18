package pl.sanders.multikinoapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewsViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("Tu będą różne informacje");
    }

    public LiveData<String> getText() {
        return mText;
    }
}