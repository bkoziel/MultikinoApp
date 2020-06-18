package pl.sanders.multikinoapp.ui.repertoire;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RepertoireViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RepertoireViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("Tu będą filmy");

    }

    public LiveData<String> getText() {
        return mText;
    }
}