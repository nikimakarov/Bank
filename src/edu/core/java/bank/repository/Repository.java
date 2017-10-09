package edu.core.java.bank.repository;

import edu.core.java.bank.vo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public abstract class Repository<V extends ValueObject> {

    public Map<Long, V> valueObjects;
    public Logger logger = LoggerFactory.getLogger(Repository.class);

    public void addValueObject(V v) {
        if (v != null) {
            valueObjects.put(v.getId(), v);
            logger.info("Value object added");
        } else {
            logger.info("Value object is null");
        }
    }

    public V getValueObject(Long id) {
        V result = valueObjects.get(id);
        if (result == null) {
            logger.info("Value object with id = " + id + " not found");
        } else {
            logger.info("Value object with id = " + id + " found");
        }
        return result;
    }

    public void updateValueObject(V v) {
        if (v != null && valueObjects.containsKey(v.getId())) {
            valueObjects.put(v.getId(), v);
            logger.info("Value object with id = " + v.getId() + " updated");
        } else {
            logger.info("Value object with new data is null or there is no element with that id");
        }
    }

    public void deleteValueObject(Long id) {
        if (valueObjects.remove(id) != null) {
            logger.info("Value object with id = " + id + " successfully deleted");
        } else {
            logger.info("Value object with id = " + id + " wasn't deleted");
        }
    }

    public Map<Long, V> getAllValueObjects() {
        return valueObjects;
    }

    public boolean contain(Long id) {
        return valueObjects.containsKey(id);
    }
}
