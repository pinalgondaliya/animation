package com.example.myapplication420365;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // animation : object animator, value animator, xml, physic based animation
    // firebase

//    Button b;

//    boolean isVisiobl = true;

    DatabaseReference dbRef;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // animation

//        b = findViewById(R.id.button);
//
//        SpringAnimation s = new SpringAnimation(b, DynamicAnimation.TRANSLATION_Y);
//        s.setSpring(new SpringForce(200).setStiffness(100));
//
//        CardView c = findViewById(R.id.c);
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                if (isVisiobl){
////                    c.setVisibility(View.GONE);
////                    isVisiobl = false;
////                }else {
////                    c.setVisibility(View.VISIBLE);
////                    isVisiobl = true;
////                }
//
////                s.start();
//
////                ObjectAnimator o = ObjectAnimator.ofFloat(b, "rotation",10000);
////                o.setInterpolator(new AccelerateDecelerateInterpolator());
////                o.setDuration(3000);
////                o.start();
//            }
//        });


        // firebase


        FirebaseDatabase f = FirebaseDatabase.getInstance();
        dbRef = f.getReference("key1");
        Log.d("TAG", "onCreate: "+dbRef.getKey());


        tv = findViewById(R.id.tv);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tv.setText(""+snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void setData(View view) {
        dbRef.setValue("Hello world firebase");
    }

    public void getData(View view) {
    }
}