package com.perez.ptbackend.infrastructore.persistence.jpa.respositories;


import java.util.Optional;
import java.util.UUID;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
                extends JpaRepository<UserEntity, UUID>, JpaSpecificationExecutor<UserEntity> {

        Optional<UserEntity> findByUsername(String username);

        boolean existsByUsername(String username);

        @Query(value = " Select count(*) from users where username =:usernameParam and id !=:idParam",
                        nativeQuery = true)
        int existsByUsernameAndDifferentId(@Param("usernameParam") String usernameParam,
                        @Param("idParam") UUID idParam);
}
