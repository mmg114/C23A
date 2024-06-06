package co.com.ps.C23A.controller;


import co.com.ps.C23A.domain.Category;
import co.com.ps.C23A.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;


    @GetMapping("/name/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name){
        try {
            return ResponseEntity.ok(categoryService.findByName(name));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        try {
            return ResponseEntity.ok(categoryService.save(category));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }


    }



}
