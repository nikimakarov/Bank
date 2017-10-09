package edu.core.java.bank.loader;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Product;
import edu.core.java.bank.domain.Transaction;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.ValueObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class ProductLoader extends Loader<Product> {

    public ProductLoader(Repository repository, Translator translator) {
        super(repository, translator);
    }

    public Product getEntityById(Long id){
        ValueObject vo = repository.getValueObject(id);
        Product product = null;
        if (vo != null) {
            product = (Product) translator.fromValueToDomain(vo);
        }
        return product;
    }
}