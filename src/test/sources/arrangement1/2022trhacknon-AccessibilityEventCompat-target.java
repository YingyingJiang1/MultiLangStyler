package pair7;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class AccessibilityEventCompat {
    private static final AccessibilityEventVersionImpl IMPL;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;



    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityEventIcsImpl();
        } else {
            IMPL = new AccessibilityEventStubImpl();
        }
    }

}
