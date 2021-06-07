package com.perez.ptbackend.core.ports.base;

import java.util.List;
import com.perez.ptbackend.core.models.UserDateAuditModel;
import com.perez.ptbackend.infrastructore.persistence.jpa.base.UserDateAuditEntity;
import org.springframework.data.domain.Page;

public interface ConvertJpa<T extends UserDateAuditEntity, M extends UserDateAuditModel<I>, I> {

    T convert(M model);

    M convert(T entity);

    List<M> convert(List<T> listEntity);

    Page<M> convertPageEntityToModel(Page<T> entity);

}
