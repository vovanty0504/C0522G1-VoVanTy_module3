package service;

import modle.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();

    void add(Product product);

    void update(Product product);

    void remove(int id);

    void view(int id);

    Product searchById(int id);

    List<Product> searchName(String Name);

    void save(Product product);


}
