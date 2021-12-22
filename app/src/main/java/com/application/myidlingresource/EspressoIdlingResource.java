package com.application.myidlingresource;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResource {
    private static final String RESOURCE = "GLOBAL";
    private static final CountingIdlingResource espressoIdlingResource = new CountingIdlingResource(RESOURCE);

    static void increment(){
        espressoIdlingResource.increment();
    }
    static void decrement(){
        espressoIdlingResource.decrement();
    }
    static IdlingResource getEspressoIdlingResource(){
        return espressoIdlingResource;
    }
}
