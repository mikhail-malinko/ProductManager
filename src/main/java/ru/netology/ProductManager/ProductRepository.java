package ru.netology.ProductManager;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        if (findById(product.getId()) == product) {
            throw new AlreadyExistsException("Element with id: " + product.getId() + "already exists");
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public void removeById(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException("Element with id: " + removeId + " not found");
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int findID) {
        for (Product product : products) {
            if (product.getId() == findID) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }
}