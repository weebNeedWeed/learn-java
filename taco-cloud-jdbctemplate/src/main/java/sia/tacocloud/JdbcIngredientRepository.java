package sia.tacocloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from Ingredient",
                this::mapRowToIngredient
        );
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> result = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id
        );

        return result.isEmpty() ? Optional.empty() : Optional.of(result.getFirst());
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?,?,?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType()
        );
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }
}
