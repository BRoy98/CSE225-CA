package sh.broy.androidca225.Widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatButton;

public class HoverEffectButton extends AppCompatButton {

    public HoverEffectButton(Context context) {
        super(context);
        init();
    }

    public HoverEffectButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HoverEffectButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnTouchListener((view, motionEvent) -> {
            view.performClick();

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                ScaleAnimation scale_up = new ScaleAnimation(1f, 1.05f, 1f, 1.05f, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scale_up.setDuration(200);
                scale_up.setFillAfter(
                        true);
                view.startAnimation(scale_up);

                scale_up.setAnimationListener(new AnimationListener() {
                    @Override
                    public void onAnimationStart(final Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(final Animation animation) {
                        if (motionEvent.getAction() == 1) {
                            ScaleAnimation scale_down = new ScaleAnimation(1.05f, 1f, 1.05f, 1f,
                                    Animation.RELATIVE_TO_SELF, 0.5f,
                                    Animation.RELATIVE_TO_SELF, 0.5f);
                            scale_down.setDuration(200);
                            scale_down.setFillAfter(
                                    true);
                            view.startAnimation(scale_down);
                        }
                    }

                    @Override
                    public void onAnimationRepeat(final Animation animation) {

                    }
                });

            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                ScaleAnimation scale_down = new ScaleAnimation(1.05f, 1f, 1.05f, 1f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scale_down.setDuration(200);
                scale_down.setFillAfter(
                        true);
                view.startAnimation(scale_down);

            }
            return false;
        });
    }
}
