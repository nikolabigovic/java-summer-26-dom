package com.la.summer.repository;

import com.la.summer.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Autor getById(Integer id) {
        String sql = "SELECT * FROM autor WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Autor.class, id);
    }

    public void updateName(String name, Integer id) {
        String sql = "UPDATE autor SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }
}
