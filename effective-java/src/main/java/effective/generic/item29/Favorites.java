package effective.generic.item29;

import java.util.HashMap;
import java.util.Map;

/**
 * Typesafe heterogeneous container pattern - implementation
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/21/13
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

//    public <T> void putFavorite(Class<T> type, T instance){
//        if (type == null)
//            throw new NullPointerException("type is null");
//        favorites.put(type, instance);
//    }

    //Achieving runtime type safety with a dynamic cast
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
