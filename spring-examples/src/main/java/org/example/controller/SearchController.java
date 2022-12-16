package org.example.controller;

import org.example.dto.Filter;
import org.example.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @GetMapping
    public ResultDto search(@RequestParam("filter") Filter filter) {
        return new ResultDto();
    }
}
