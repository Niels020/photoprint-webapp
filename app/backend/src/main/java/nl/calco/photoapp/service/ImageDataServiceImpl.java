package nl.calco.photoapp.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.ImageData;
import nl.calco.photoapp.entity.OrderDefinition;
import nl.calco.photoapp.repository.ImageDataRepository;
import nl.calco.photoapp.repository.OrderDefinitionRepository;
import nl.calco.photoapp.util.ImageUtils;

@AllArgsConstructor
@Service
public class ImageDataServiceImpl implements ImageDataService {

    ImageDataRepository imageDataRepository;
    OrderDefinitionRepository orderDefinitionRepository;

    @Override
    public byte[] getImageData(Long orderDefinitionId) {
        Optional<ImageData> optionalImageData = imageDataRepository.findById(orderDefinitionId);
        byte[] images = ImageUtils.decompressImage(optionalImageData.get().getImage());
        return images;
    }

    @Override
    public ImageData saveImageData(MultipartFile file, Long orderDefinitionId) throws IOException {

        ImageData imageData = ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtils.compressImage(file.getBytes())).build();

        OrderDefinition orderDefinition = orderDefinitionRepository.findById(orderDefinitionId).get();
        imageData.setOrderDefinition(orderDefinition);

        return imageDataRepository.save(imageData);
    }
}
