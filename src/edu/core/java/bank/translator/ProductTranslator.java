package edu.core.java.bank.translator;

import edu.core.java.bank.domain.Product;
import edu.core.java.bank.vo.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class ProductTranslator implements Translator<ProductVO, Product>{

    private static final Logger logger = LoggerFactory.getLogger(ProductTranslator.class);

    @Override
    public ProductVO fromDomainToValue(Product product) {
        ProductVO productVO = null;
        if (product != null) {
            productVO = new ProductVO(product.getName(), product.getPrice());
        } else {
            logger.debug("Domain Object was null, so translation not possible");
        }
        return productVO;
    }

    @Override
    public  Product fromValueToDomain(ProductVO productVO) {
        Product product = null;
        if (productVO != null) {
            product = new Product(productVO.name, productVO.price);
        } else {
            logger.debug("Value Object was null, so translation not possible");
        }
        return product;
    }

}