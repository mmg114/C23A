package co.com.ps.C23A.repository;

import co.com.ps.C23A.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {
}
