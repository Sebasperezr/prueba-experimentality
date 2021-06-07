
package com.perez.ptbackend.infrastructore.persistence.jpa.respositories;


import java.util.UUID;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID>,
                JpaSpecificationExecutor<ProductEntity> {



}
