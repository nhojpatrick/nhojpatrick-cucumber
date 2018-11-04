public abstract class AbstractPath
        implements JsonPath {

    private final String name;

    public AbstractPath(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isArray() {
        return (this instanceof JsonPathArray);
    }

    @Override
    public boolean isAttribute() {
        return (this instanceof JsonPathAttribute);
    }

    @Override
    public boolean isObject() {
        return (this instanceof JsonPathObject);
    }

}
