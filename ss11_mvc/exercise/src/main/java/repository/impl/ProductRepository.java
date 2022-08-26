package repository.impl;

import modle.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bánh Trung Thu", 100000, "Bánh Bao Ngon", "Văn Tý"));
        productList.add(new Product(2, "Bánh Gạo", 1000000, "Bánh dở", "Huy Đặng"));
        productList.add(new Product(3, "Bánh Snack", 1000, "Bánh bim bim", "phúc"));
        productList.add(new Product(4, "Bánh mì", 150000, "Bánh Bao Ngon", "Văn Tý"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.add(product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().contains(name)) {
                products.add(item);
            }
        }
        return products;
    }

    @Override
    public Product searchById(int id) {
        return productList.get(id);
    }
}
