package com.developeralamin.bkash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.developeralamin.bkash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Animation lef_to_right, right_to_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        lef_to_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        right_to_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);


        binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.moenyTv.getText() == getString(R.string.tap_of_blacne)) {
                    binding.moneyIconeLeft.startAnimation(lef_to_right);

                    new CountDownTimer(2000, 1000) {

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            binding.moenyTv.setText(R.string.blace_amout);

                            binding.moneyIconeRight.setVisibility(View.VISIBLE);
                            binding.moneyIconeLeft.setVisibility(View.INVISIBLE);
                            new CountDownTimer(100, 500) {

                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {

                                    binding.moenyTv.startAnimation(right_to_left);

                                    new CountDownTimer(2000, 1000) {

                                        @Override
                                        public void onTick(long millisUntilFinished) {

                                        }

                                        @Override
                                        public void onFinish() {
                                            binding.moneyIconeLeft.setVisibility(View.VISIBLE);
                                            binding.moneyIconeRight.setVisibility(View.INVISIBLE);
                                            binding.moenyTv.setText(R.string.tap_of_blacne);
                                        }
                                    }.start();

                                }
                            }.start();
                        }
                    }.start();

                }

            }
        });

        if (binding.moenyTv.getText() == getString(R.string.tap_of_blacne)) {
            binding.moneyIconeLeft.setVisibility(View.VISIBLE);
            binding.moneyIconeRight.setVisibility(View.INVISIBLE);
        } else {
            binding.moneyIconeLeft.setVisibility(View.INVISIBLE);
            binding.moneyIconeRight.setVisibility(View.VISIBLE);
        }
    }
}