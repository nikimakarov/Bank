package edu.core.java.bank.loader;

import edu.core.java.bank.domain.DomainObject;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public abstract class Loader<D extends DomainObject> {

    protected Repository repository;
    protected Translator translator;
    Logger logger = LoggerFactory.getLogger(Loader.class);

    public Loader(Repository repository, Translator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    public abstract D getEntityById(Long id);

    public List<D> getAllEntities() {
        Map<Long, ValueObject> entities = repository.getAllValueObjects();
        List<D> result = new LinkedList<>();
        for (ValueObject vo : entities.values()) {
            result.add((D) getEntityById(vo.getId()));
        }
        logger.info("Domain objects successfully loaded");
        return result;
    }
}
