package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        String sql = "INSERT INTO products (title, price) VALUES (?, ?)";
        try (
            var conn = dataSource.getConnection();
            var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, product.getTitle());
            stmt.setInt(2, product.getPrice());
            stmt.executeUpdate();
            var res = stmt.getGeneratedKeys();
            if (res.next()) {
                product.setId(res.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Product> find(long id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (
            var conn = dataSource.getConnection();
            var stmt = conn.prepareStatement(sql);
        ) {
            stmt.setLong(1, id);
            var res = stmt.executeQuery();
            if (res.next()) {
                String title = res.getString("title");
                int price = res.getInt("price");
                return Optional.of(new Product(title, price));
            }
            return Optional.empty();
        }
    }

    public static List<Product> getEntities() throws SQLException {
        String sql = "SELECT * FROM products";
        try (
            var conn = dataSource.getConnection();
            var stmt = conn.prepareStatement(sql);
        ) {
            var res = stmt.executeQuery();
            List<Product> products = new ArrayList<>();
            while (res.next()) {
                long id = res.getLong("id");
                String title = res.getString("title");
                int price = res.getInt("price");
                Product product = new Product(title, price);
                product.setId(id);
                products.add(product);
            }
            return products;
        }
    }
    // END
}
