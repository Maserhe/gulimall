package com.jpg6.gulimall.search.controller;

import com.jpg6.gulimall.search.service.MallSearchService;
import com.jpg6.gulimall.search.vo.SearchParam;
import com.jpg6.gulimall.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchController {


    @Autowired
    MallSearchService mallSearchService;


    @GetMapping("/list.html")
    public String listPage(SearchParam searchParam, Model model, HttpServletRequest request) {

        String string = request.getQueryString();
        searchParam.set_queryString(string);

        SearchResult result = mallSearchService.search(searchParam);
        model.addAttribute("result", result);
        return "list";
    }
}
