package services;

import java.util.HashMap;
import java.util.Map;

public class GenericService<T> {
    private static final Map<Class<?>, Object> instances = new HashMap<>();
    private T service;

    // Private constructor to prevent instantiation
    private GenericService(T service) {
        this.service = service;
    }

    // Method to get the singleton instance
    @SuppressWarnings("unchecked")
    public static synchronized <T> T getInstance(Class<T> clazz) {
        if (!instances.containsKey(clazz)) {
            try {
                T serviceInstance = clazz.getDeclaredConstructor().newInstance();
                instances.put(clazz, serviceInstance);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create service instance", e);
            }
        }
        return (T) instances.get(clazz);
    }
}
