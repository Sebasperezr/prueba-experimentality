package com.perez.ptbackend.core.ports.base;

import java.util.UUID;
import com.perez.ptbackend.core.models.FilterModel;
import com.perez.ptbackend.core.models.UserDateAuditModel;
import org.springframework.data.domain.Page;

public interface CRUDService<T extends UserDateAuditModel<I>, I> {
     T save(T model);

     T update(T model);

     Page<T> list(FilterModel<T> model);

     T findById(UUID id);

     T deleteById(UUID id);

}
