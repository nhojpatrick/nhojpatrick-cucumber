public class JsonPathAttribute
        extends AbstractPath
        implements JsonPath {

    public JsonPathAttribute(final String name) {
        super(name);
    }

    @Override
    public JsonPath getChild() {
        throw new UnsupportedOperationException("Attribute does not have child");
    }

}
