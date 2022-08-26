package repository;

import modle.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> search(String name);

    Product searchById(int id);

}
