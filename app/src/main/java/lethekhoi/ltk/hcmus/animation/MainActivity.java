package lethekhoi.ltk.hcmus.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgAlpha, imgScale1, imgScale2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAlpha = findViewById(R.id.imageviewAlpha);
        imgScale1 = findViewById(R.id.imageviewScale1);
        imgScale2 = findViewById(R.id.imageviewScale2);
        imgScale2.setVisibility(View.GONE);
        //type casting:

//        final AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
//        imgAlpha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                view.startAnimation(alphaAnimation);
//            }
//        });
//scale
        //pivotx<50% : thì scale qua phải và ngược lại
        //pivoty<50% : thì scale xuống dưới và ngược lại
        Context context;
        final Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animationAlphaGrab = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        imgScale1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgScale2.setVisibility(View.GONE);
                v.startAnimation(animationScale);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgScale2.setVisibility(View.VISIBLE);
                        imgScale2.startAnimation(animationAlphaGrab);
                    }
                }, animationScale.getDuration());
            }
        });


    }
}
