package com.github.nhojpatrick.cucumber.json.testing.objects;

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
        "lnName",
        "lnId",
        "lnBottom"
})
@SuppressFBWarnings(value = "CN_IDIOM_NO_SUPER_CALL", justification = "Managed by JodaBeans")
@SuppressWarnings("PMD.UselessParentheses")
public class MyListNestedObj
        implements Bean,
        Cloneable {

    @JsonProperty
    @PropertyDefinition(set = "")
    private final String lnName;

    @JsonProperty
    @PropertyDefinition(set = "")
    private final int lnId;

    @JsonProperty
    @PropertyDefinition(set = "")
    private final MyListNestedBottomObj lnBottom;

    MyListNestedObj() {
        this.lnName = null;
        this.lnId = 0;
        this.lnBottom = null;
    }

    public MyListNestedObj(final String lnName,
                           final int lnId,
                           final MyListNestedBottomObj lnBottom) {
        this.lnName = lnName;
        this.lnId = lnId;
        this.lnBottom = lnBottom;
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code MyListNestedObj}.
     * @return the meta-bean, not null
     */
    public static MyListNestedObj.Meta meta() {
        return MyListNestedObj.Meta.INSTANCE;
    }

    static {
        MetaBean.register(MyListNestedObj.Meta.INSTANCE);
    }

    @Override
    public MyListNestedObj.Meta metaBean() {
        return MyListNestedObj.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the lnName.
     * @return the value of the property
     */
    public String getLnName() {
        return lnName;
    }

    /**
     * Gets the the {@code lnName} property.
     * @return the property, not null
     */
    public final Property<String> lnName() {
        return metaBean().lnName().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the lnId.
     * @return the value of the property
     */
    public int getLnId() {
        return lnId;
    }

    /**
     * Gets the the {@code lnId} property.
     * @return the property, not null
     */
    public final Property<Integer> lnId() {
        return metaBean().lnId().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the lnBottom.
     * @return the value of the property
     */
    public MyListNestedBottomObj getLnBottom() {
        return lnBottom;
    }

    /**
     * Gets the the {@code lnBottom} property.
     * @return the property, not null
     */
    public final Property<MyListNestedBottomObj> lnBottom() {
        return metaBean().lnBottom().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public MyListNestedObj clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            MyListNestedObj other = (MyListNestedObj) obj;
            return JodaBeanUtils.equal(getLnName(), other.getLnName()) &&
                    (getLnId() == other.getLnId()) &&
                    JodaBeanUtils.equal(getLnBottom(), other.getLnBottom());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getLnName());
        hash = hash * 31 + JodaBeanUtils.hashCode(getLnId());
        hash = hash * 31 + JodaBeanUtils.hashCode(getLnBottom());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("MyListNestedObj{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("lnName").append('=').append(JodaBeanUtils.toString(getLnName())).append(',').append(' ');
        buf.append("lnId").append('=').append(JodaBeanUtils.toString(getLnId())).append(',').append(' ');
        buf.append("lnBottom").append('=').append(JodaBeanUtils.toString(getLnBottom())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code MyListNestedObj}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code lnName} property.
         */
        private final MetaProperty<String> lnName = DirectMetaProperty.ofReadOnly(
                this, "lnName", MyListNestedObj.class, String.class);
        /**
         * The meta-property for the {@code lnId} property.
         */
        private final MetaProperty<Integer> lnId = DirectMetaProperty.ofReadOnly(
                this, "lnId", MyListNestedObj.class, Integer.TYPE);
        /**
         * The meta-property for the {@code lnBottom} property.
         */
        private final MetaProperty<MyListNestedBottomObj> lnBottom = DirectMetaProperty.ofReadOnly(
                this, "lnBottom", MyListNestedObj.class, MyListNestedBottomObj.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "lnName",
                "lnId",
                "lnBottom");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case -1099011283:  // lnName
                    return lnName;
                case 3325501:  // lnId
                    return lnId;
                case 81717837:  // lnBottom
                    return lnBottom;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends MyListNestedObj> builder() {
            return new DirectBeanBuilder<>(new MyListNestedObj());
        }

        @Override
        public Class<? extends MyListNestedObj> beanType() {
            return MyListNestedObj.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code lnName} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> lnName() {
            return lnName;
        }

        /**
         * The meta-property for the {@code lnId} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Integer> lnId() {
            return lnId;
        }

        /**
         * The meta-property for the {@code lnBottom} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<MyListNestedBottomObj> lnBottom() {
            return lnBottom;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1099011283:  // lnName
                    return ((MyListNestedObj) bean).getLnName();
                case 3325501:  // lnId
                    return ((MyListNestedObj) bean).getLnId();
                case 81717837:  // lnBottom
                    return ((MyListNestedObj) bean).getLnBottom();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1099011283:  // lnName
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: lnName");
                case 3325501:  // lnId
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: lnId");
                case 81717837:  // lnBottom
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: lnBottom");
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------

}
