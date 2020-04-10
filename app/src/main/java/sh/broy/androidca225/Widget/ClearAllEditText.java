package sh.broy.androidca225.Widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Objects;

public class ClearAllEditText extends AppCompatEditText {

    public static enum Location {
        LEFT(0), RIGHT(2);

        final int idx;

        private Location(int idx) {
            this.idx = idx;
        }
    }

    public ClearAllEditText(Context context) {
        super(context);
        init();
    }

    public ClearAllEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearAllEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener f) {
    }

    private Location loc = Location.RIGHT;

    private Drawable clearButton;

    private void init() {
        setOnTouchListener((v, event) -> {

            v.performClick();

            if (getDisplayedDrawable() != null) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                int left = (loc == Location.LEFT) ? 0
                        : getWidth() - getPaddingRight() - clearButton.getIntrinsicWidth();
                int right = (loc == Location.LEFT) ? getPaddingLeft() + clearButton.getIntrinsicWidth() : getWidth();
                boolean tappedX = x >= left && x <= right && y >= 0 && y <= (getBottom() - getTop());
                if (tappedX) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        setText("");
                        Objects.requireNonNull(getText()).clear();
                    }
                    return true;
                }
            }
            return false;
        });

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {
                if (isFocused()) {
                    setClearIconVisible(Objects.requireNonNull(getText()).toString().length() > 0);
                }
            }

            @Override
            public void afterTextChanged(final Editable editable) {

            }
        });

        initIcon();
        setClearIconVisible(false);
    }

    private void initIcon() {
        clearButton = null;
        if (loc != null) {
            clearButton = getCompoundDrawables()[loc.idx];
        }
        if (clearButton == null) {
            clearButton = getResources().getDrawable(android.R.drawable.presence_offline);
        }
        clearButton.setBounds(5, 5, 100, 100);
    }

    private Drawable getDisplayedDrawable() {
        return (loc != null) ? getCompoundDrawables()[loc.idx] : null;
    }

    protected void setClearIconVisible(boolean visible) {
        Drawable[] cd = getCompoundDrawables();
        Drawable displayed = getDisplayedDrawable();
        boolean wasVisible = (displayed != null);
        if (visible != wasVisible) {
            Drawable x = visible ? clearButton : null;
            super.setCompoundDrawables((loc == Location.LEFT) ? x : cd[0], cd[1], (loc == Location.RIGHT) ? x : cd[2],
                    cd[3]);
        }
    }
}
