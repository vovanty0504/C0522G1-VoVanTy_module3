package service.impl;


import modle.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;


public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();


    @Override
    public List<Product> display() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.findById(product.getId());
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void view(int id) {

    }

    @Override
    public Product searchById(int id) {
        return productRepository.searchById(id);
    }

    @Override
    public List<Product> searchName(String name) {
        return productRepository.search(name);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
