import java.util.HashMap;
import java.util.Map;

public class Transform {

    public static void main(final String[] args) {
        System.out.println("########");
        System.out.println("######## Add");
        System.out.println("########");
        transform(new HashMap<>(), "alpha", (Map<String, Object> input, String key) -> input.put(key, castTo("java.lang.String", "qwerty1")));
        System.out.println("########");
        transform(new HashMap<>(), "alpha.bravo", (Map<String, Object> input, String key) -> input.put(key, castTo("java.lang.String", "qwerty2")));
        System.out.println("########");
        transform(new HashMap<>(), "alpha.bravo.charlie", (Map<String, Object> input, String key) -> input.put(key, castTo("java.lang.String", "qwerty3")));
        System.out.println("########");
        transform(new HashMap<>(), "alpha.bravo.charlie.delta", (Map<String, Object> input, String key) -> input.put(key, castTo("java.lang.String", "qwerty4")));

        System.out.println("########");
        System.out.println("######## Remove");
        System.out.println("########");
        transform(new HashMap<>(), "alpha", (Map<String, Object> input, String key) -> input.remove(key));
        System.out.println("########");
        final Map<String, Object> alphaDelete = new HashMap<>();
        alphaDelete.put("alpha", "origional");
        transform(alphaDelete, "alpha", (Map<String, Object> input, String key) -> input.remove(key));
        System.out.println("########");
        final Map<String, Object> alphaBravoDelete = new HashMap<>();
        alphaBravoDelete.put("alpha", new HashMap<>());
        transform(alphaBravoDelete, "alpha", (Map<String, Object> input, String key) -> input.remove(key));

        System.out.println("########");
        System.out.println("######## UpperCase");
        System.out.println("########");
        transform(new HashMap<>(), "alpha", (Map<String, Object> input, String key) -> {
            final Object obj = input.get(key);
            if (obj instanceof String) {
                final String str = (String) obj;
                input.put(key, str.toUpperCase());
            }
        });
        System.out.println("########");
        final Map<String, Object> upperCase = new HashMap<>();
        upperCase.put("alpha", "uppercase");
        transform(upperCase, "alpha", (Map<String, Object> input, String key) -> {
            final Object obj = input.get(key);
            if (obj instanceof String) {
                final String str = (String) obj;
                input.put(key, str.toUpperCase());
            }
        });
    }

}
