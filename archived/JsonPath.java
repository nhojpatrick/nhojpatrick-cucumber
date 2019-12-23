public interface JsonPath {

    JsonPath getChild();

    String getName();

    boolean isArray();

    boolean isAttribute();

    boolean isObject();

}
