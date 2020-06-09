package com.example.sample;

import java.util.List;

public interface IFireStoreLoadDone {

    void onFireStoreLoadSuccess(List<Movie> movies) ;
    void onFireStoreLoadFailed(String message);
}
