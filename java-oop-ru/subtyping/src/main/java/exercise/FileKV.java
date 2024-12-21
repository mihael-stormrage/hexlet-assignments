package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private final Map<String, String> cache = new HashMap<>();
    private final String filepath;
    private boolean isLocked = false;

    FileKV(String filepath, Map<String, String> kv) {
        this.filepath = filepath;
        this.cache.putAll(kv);
    }

    private void lock() {
        if (isLocked) {
            throw new IllegalStateException("Storage is locked");
        }
        isLocked = true;
    }

    private void unlock() {
        isLocked = false;
    }

    private Map<String, String> fetchStorage() {
        String file = Utils.readFile(filepath);
        return Utils.deserialize(file);
    }

    private void writeStorage(Map<String, String> storage) {
        Utils.writeFile(filepath, Utils.serialize(storage));
        unlock();
    }

    @Override
    public void set(String key, String value) {
        lock();
        Map<String, String> storage = fetchStorage();
        storage.put(key, value);
        cache.put(key, value);
        writeStorage(storage);
    }

    @Override
    public void unset(String key) {
        lock();
        Map<String, String> storage = fetchStorage();
        storage.remove(key);
        cache.remove(key);
        writeStorage(storage);
    }

    @Override
    public String get(String key, String defaultValue) {
        String cached = cache.get(key);
        if (cached != null) {
            return cached;
        }

        String value = fetchStorage().get(key);
        if (value == null) {
            return defaultValue;
        }
        cache.put(key, value);
        return value;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(cache);
    }
}
// END
