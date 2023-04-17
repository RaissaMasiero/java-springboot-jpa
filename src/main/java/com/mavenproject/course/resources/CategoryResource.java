package com.mavenproject.course.resources;

import com.mavenproject.course.entities.Category;
import com.mavenproject.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // diz que é resurso web implementado por controlador rest
@RequestMapping(value = "/categories") // nome do recurso
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping // diz que responde a requisição get do http
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){ // pathvariable: aceita o valor vindo da url
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
