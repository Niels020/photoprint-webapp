package nl.calco.photoapp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import nl.calco.photoapp.entity.ImageData;

public interface ImageDataService {
    byte[] getImageData(Long orderDefinitionId);

    ImageData saveImageData(MultipartFile file, Long orderDefinitionId) throws IOException;
}
