public class JsonPathArray
        extends AbstractPath
        implements JsonPath {

    private final JsonPath child;
    private final int index;

    public JsonPathArray(final JsonPath child, final String name, final int index) {
        super(name);
        this.child = child;
        this.index = index;
    }

    @Override
    public JsonPath getChild() {
        return this.child;
    }

    public int getIndex() {
        return this.index;
    }

}
