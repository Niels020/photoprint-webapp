package nl.calco.photoapp.web;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.ImageData;
import nl.calco.photoapp.service.ImageDataService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/image_data")
public class ImageDataController {

    ImageDataService service;

    @GetMapping("/{customerOrderId}")
    public ResponseEntity<?> getImage(@PathVariable Long customerOrderId) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png"))
                .body(service.getImageData(customerOrderId));
    }

    @PostMapping("/order_definition/{orderDefinitionId}")
    public ResponseEntity<ImageData> saveImageData(@RequestParam("image") MultipartFile file,
            @PathVariable Long orderDefinitionId) throws IOException {
        return new ResponseEntity<>(service.saveImageData(file, orderDefinitionId), HttpStatus.CREATED);
    }

}
