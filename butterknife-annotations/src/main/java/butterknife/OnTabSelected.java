package butterknife;

import android.support.annotation.IdRes;
import android.text.TextWatcher;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;


/**
 * TODO
 */
@Target(METHOD)
@Retention(CLASS)
@ListenerClass(
        targetType = "android.support.design.widget.TabLayout",
        setter = "setOnTabSelectedListener",
        type = "android.support.design.widget.TabLayout.OnTabSelectedListener",
        callbacks = OnTabSelected.Callback.class
)
public @interface OnTabSelected {
    /** View IDs to which the method will be bound. */
    @IdRes int[] value() default { View.NO_ID };

    /** Listener callback to which the method will be bound. */
    Callback callback() default Callback.TAB_SELECTED;

    /** {@link TextWatcher} callback methods. */
    enum Callback {
        /** {@link TextWatcher#onTextChanged(CharSequence, int, int, int)} */
        @ListenerMethod(
                name = "onTabSelected",
                parameters = {
                        "android.support.design.widget.TabLayout.Tab"
                }
        )
        TAB_SELECTED,
        @ListenerMethod(
                name = "onTabReselected",
                parameters = {
                        "android.support.design.widget.TabLayout.Tab"
                }
        )
        TAB_RESELECTED,
        @ListenerMethod(
                name = "onTabUnselected",
                parameters = {
                        "android.support.design.widget.TabLayout.Tab"
                }
        )
        TAB_UNSELECTED,
    }
}
