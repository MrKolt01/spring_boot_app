package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Denis Iaichnikov
 * @since 7/12/2018
 */

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE users (ID int NOT NULL AUTO_INCREMENT, NAME VARCHAR(40), AGE int)");
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO users (name, age) VALUES (?, ?)", user.getName(), user.getAge());
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            return user;
        });
    }
}
