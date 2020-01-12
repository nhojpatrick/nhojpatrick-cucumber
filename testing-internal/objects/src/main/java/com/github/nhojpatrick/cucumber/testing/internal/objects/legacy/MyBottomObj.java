package com.github.nhojpatrick.cucumber.testing.internal.objects.legacy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import java.util.Map;

@BeanDefinition
@JsonPropertyOrder({
        MyBottomObj.ALPHA
})
@SuppressFBWarnings(value = "CN_IDIOM_NO_SUPER_CALL", justification = "Managed by JodaBeans")
@SuppressWarnings("PMD.UselessParentheses")
public class MyBottomObj
        implements Bean,
        Cloneable {

    public static final String ALPHA = "alpha";

    @JsonProperty(ALPHA)
    @PropertyDefinition(set = "")
    private final String alpha;

    MyBottomObj() {
        this.alpha = null;
    }

    public MyBottomObj(final String alpha) {
        this.alpha = alpha;
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code MyBottomObj}.
     * @return the meta-bean, not null
     */
    public static MyBottomObj.Meta meta() {
        return MyBottomObj.Meta.INSTANCE;
    }

    static {
        MetaBean.register(MyBottomObj.Meta.INSTANCE);
    }

    @Override
    public MyBottomObj.Meta metaBean() {
        return MyBottomObj.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the alpha.
     * @return the value of the property
     */
    public String getAlpha() {
        return alpha;
    }

    /**
     * Gets the the {@code alpha} property.
     * @return the property, not null
     */
    public final Property<String> alpha() {
        return metaBean().alpha().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public MyBottomObj clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            MyBottomObj other = (MyBottomObj) obj;
            return JodaBeanUtils.equal(getAlpha(), other.getAlpha());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getAlpha());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(64);
        buf.append("MyBottomObj{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("alpha").append('=').append(JodaBeanUtils.toString(getAlpha())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code MyBottomObj}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code alpha} property.
         */
        private final MetaProperty<String> alpha = DirectMetaProperty.ofReadOnly(
                this, "alpha", MyBottomObj.class, String.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "alpha");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 92909918:  // alpha
                    return alpha;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends MyBottomObj> builder() {
            return new DirectBeanBuilder<>(new MyBottomObj());
        }

        @Override
        public Class<? extends MyBottomObj> beanType() {
            return MyBottomObj.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code alpha} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> alpha() {
            return alpha;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 92909918:  // alpha
                    return ((MyBottomObj) bean).getAlpha();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 92909918:  // alpha
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: alpha");
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------

}
