package com.perez.ptbackend.core.ports.inputs;

import java.util.UUID;
import com.perez.ptbackend.core.models.ImageModel;
import com.perez.ptbackend.core.ports.base.CRUDService;

public interface ImageService extends  CRUDService<ImageModel, UUID> {

}
