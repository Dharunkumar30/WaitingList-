package Dharun.com.example.acer.waitinglistapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import Dharun.com.example.acer.waitinglistapp.Database.Repository;
import Dharun.com.example.acer.waitinglistapp.Database.WaitingListEntity;

/**
 * Created by acer on 13-02-2018.
 */

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<WaitingListEntity>> mWaitingList;

    private Repository mrepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.mrepository = new Repository(application);
        this.mWaitingList = mrepository.getAllwaitinglist();
    }

     LiveData<List<WaitingListEntity>> getList(){
        return mWaitingList;
    }

     void insert(WaitingListEntity waitingListEntity){
        mrepository.insert(waitingListEntity);
    }

     void delete(WaitingListEntity waitingListEntity){
        mrepository.delete(waitingListEntity);
    }

}
