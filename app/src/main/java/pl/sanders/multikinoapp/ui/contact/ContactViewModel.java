package pl.sanders.multikinoapp.ui.contact;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public ContactViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is send fragment");





    }

    public LiveData<String> getText() {
        return mText;
    }
}