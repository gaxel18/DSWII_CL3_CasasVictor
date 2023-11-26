package pe.edu.cibertec.DSWII_CL3_CasasVictor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ImageController {

    @PostMapping("/filesimages")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        // Validar la extensión del archivo (PNG)
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }

        if (!file.getOriginalFilename().toLowerCase().endsWith(".png")) {
            return ResponseEntity.badRequest().body("Solo se permiten archivos PNG.");
        }

        try {
            String uploadDirectory = "C:\\Users\\Usuario\\Desktop\\clases\\Ciclo 6\\Desarrollo de Servicios Web 2\\Imagenes\\prueba.png";

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path filePath = Paths.get(uploadDirectory, fileName);

            file.transferTo(filePath.toFile());

            return ResponseEntity.ok("Archivo subido exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al subir el archivo.");
        }
    }
}
