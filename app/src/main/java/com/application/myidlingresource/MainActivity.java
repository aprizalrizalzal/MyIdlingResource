package com.application.myidlingresource;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
import android.os.Handler;

import com.application.myidlingresource.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            delay1();
            delay2();
        });
    }

    private void delay1() {
        EspressoIdlingResource.increment();
        new Handler().postDelayed(() -> {
            binding.textView.setText(getString(R.string.delay1));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()){
                EspressoIdlingResource.decrement();
            }
        }, 2000);
    }
    private void delay2() {
        EspressoIdlingResource.increment();
        new Handler().postDelayed(() -> {
            binding.textView.setText(getString(R.string.delay2));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, 3000);
    }
}