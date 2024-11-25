package com.s3bastiank.cybercentrum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class DBstatusController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbstatus")
    public String checkDatabaseConnection(Model model) {
        model.addAttribute("pageTitle", "Check Database Connection");
        String result;
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                result = "Successfully connected to the database!";
            } else {
                result = "Failed to connect to the database.";
            }
        } catch (SQLException e) {
            result = "Error: " + e.getMessage();
        }
        model.addAttribute("result", result);
        return "dbstatus";
    }
}
