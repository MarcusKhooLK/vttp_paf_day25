package edu.nus.iss.sg.day25.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class LogInRepo {

    @Autowired
    private JdbcTemplate template;

    public boolean queryUserAndPass(final String username, final String password) {
        final SqlRowSet result = template.queryForRowSet(Queries.SQL_SELECT_USER_BY_PASS, username, password);
        return result.next();
    }
}
