package edu.core.java.bank.translator;

import edu.core.java.bank.domain.DomainObject;
import edu.core.java.bank.vo.ValueObject;

public interface Translator<V extends ValueObject, D extends DomainObject> {
    V fromDomainToValue(D d);
    D fromValueToDomain(V v);
}
