package com.github.nhojpatrick.cucumber.state;

import com.github.nhojpatrick.cucumber.core.exceptions.EmptyKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.core.exceptions.WhitespaceKeyException;
import io.cucumber.guice.ScenarioScoped;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@ScenarioScoped
public class RunState {

    private final Map<String, Object> state = new HashMap<>();

    public RunState() {
    }

    private void internalCheckKey(final String key)
            throws IllegalKeyException {

        if (isNull(key)) {
            throw new NullKeyException();

        } else if ("".equals(key)) {
            throw new EmptyKeyException();

        } else if ("".equals(key.trim())) {
            throw new WhitespaceKeyException();
        }
    }

    private <T> void internalCheckTypeClass(final Class<T> tClass)
            throws NullTypeClassException {

        if (isNull(tClass)) {
            throw new NullTypeClassException();
        }
    }

    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    private <T> T internalGet(final String key, final Class<T> tClass)
            throws TypeMismatchException {

        final Object valueAsObj = this.state.get(key);
        try {
            final T value = tClass.cast(valueAsObj);
            return value;

        } catch (final ClassCastException cce) {
            throw new TypeMismatchException(tClass, cce);
        }
    }

    /**
     * <p>Clear the value defined by key from the run state.</p>
     *
     * @param key the key to use.
     * @throws IllegalKeyException thrown if key is invalid.
     */
    public void clear(final String key)
            throws IllegalKeyException {

        internalCheckKey(key);

        this.state.remove(key);
    }

    /**
     * <p>Get a copy of the current run state.</p>
     *
     * @return unmodifiable clone of the current run state.
     */
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public Map<String, Object> get() {
        final Map<String, Object> clone = Collections.unmodifiableMap(new HashMap<>(this.state));
        return clone;
    }

    /**
     * <p>Get the value defined by key from the run state.</p>
     *
     * @param key    the key to use.
     * @param tClass the value Class.
     * @param <T>    the Type of the value.
     * @return the value for the key supplied as Class typed.
     * @throws IllegalKeyException       thrown if key is invalid.
     * @throws IllegalTypeClassException thrown if type class is invalid.
     * @throws TypeMismatchException     thrown if run state contains key but the value is not of type {@code tClass}.
     */
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public <T> T get(final String key, final Class<T> tClass)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        internalCheckKey(key);
        internalCheckTypeClass(tClass);

        final T value = internalGet(key, tClass);
        return value;
    }

    /**
     * @param key the key to use.
     * @return {@code true} if run state contains key, otherwise {@code false}.
     * @throws IllegalKeyException thrown if key is invalid.
     */
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public boolean isSet(final String key)
            throws IllegalKeyException {

        internalCheckKey(key);

        final boolean isSet = this.state.containsKey(key);
        return isSet;
    }

    /**
     * @param key    the key to use.
     * @param tClass the value Class.
     * @param <T>    the Type of the value.
     * @return {@code true} if run state contains key, the value is not null and also it is of type {@code tClass},
     * otherwise {@code false}.
     * @throws IllegalKeyException       thrown if key is invalid.
     * @throws IllegalTypeClassException thrown if type class is invalid.
     * @throws TypeMismatchException     thrown if run state contains key but the value is not of type {@code tClass}.
     */
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public <T> boolean isSet(final String key, final Class<T> tClass)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        internalCheckKey(key);
        internalCheckTypeClass(tClass);

        final boolean isSet = internalGet(key, tClass) != null;
        return isSet;
    }

    /**
     * @param key the key to use.
     * @return {@code false} if run state contains key, the value is not null and also it is of type {@code tClass},
     * otherwise {@code true}.
     * @throws IllegalKeyException thrown if key is invalid.
     */
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public boolean isUnset(final String key)
            throws IllegalKeyException {

        internalCheckKey(key);

        final boolean isUnset = !this.state.containsKey(key);
        return isUnset;
    }

    /**
     * <p>Set run state for a specific key to a specific value</p>
     *
     * @param key   the key to use.
     * @param value the value to set.
     * @throws IllegalKeyException thrown if key is invalid.
     */
    public void set(final String key, final Object value)
            throws IllegalKeyException {

        internalCheckKey(key);

        this.state.put(key, value);
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.state)
                .toString();
        return toString;
    }

}
