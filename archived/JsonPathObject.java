public class JsonPathObject
        extends AbstractPath
        implements JsonPath {

    private final JsonPath child;

    public JsonPathObject(final JsonPath child, final String name) {
        super(name);
        this.child = child;
    }

    @Override
    public JsonPath getChild() {
        return this.child;
    }

}
