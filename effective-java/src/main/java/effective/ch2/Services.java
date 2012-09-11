package effective.ch2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access
 *
 * @author Thomson Tang
 * @since 12-9-3
 */
public class Services {
    private Services() {} //Prevents instantiation

    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    //Provider registration API
    public static void registerDefaultProvider(Provider p) {
        registerDefaultProvider(DEFAULT_PROVIDER_NAME, p);
    }
    private static void registerDefaultProvider(String name, Provider p) {
        providers.put(name, p);
    }

    //Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    private static Service newInstance(String name) {
        Provider p = providers.get(name);
        if(p == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }
}
