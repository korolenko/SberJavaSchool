package homework8.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepositoryDAO {
    @Autowired
    private NamedParameterJdbcTemplate template;

    public void save() {

    }
}
