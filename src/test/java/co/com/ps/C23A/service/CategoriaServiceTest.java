package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Category;
import co.com.ps.C23A.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {


    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private Category category;

    @BeforeEach
    void setUp(){
        category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("Congelados");
    }

    @Test
    void testFindById(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        Category categoryTmp= categoriaService.findById(1L);
        assertNotNull(categoryTmp);
        assertEquals("Congelados",categoryTmp.getCategoryName());
    }

    @Test
    void testDelete(){
        when(categoryRepository.existsById(1L)).thenReturn(true);
        doNothing().when(categoryRepository).deleteById(1L);
        categoriaService.delete(1L);
        verify(categoryRepository,times(1)).deleteById(1L);
    }

    @Test
    void testDeleteNotFound(){
        when(categoryRepository.existsById(1L)).thenReturn(false);
        Exception exception =  assertThrows(RuntimeException.class,()->{
            categoriaService.delete(1L);
        });
        assertEquals("Category not found with id: 1",exception.getMessage());

    }


}
