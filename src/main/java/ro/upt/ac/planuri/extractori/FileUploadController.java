package ro.upt.ac.planuri.extractori;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;
import java.nio.file.Path;

@Controller
public class FileUploadController {
	
    // Obține valoarea limitei de fișiere din configurație
    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;
	
    private final String UPLOAD_DIR = "uploads/";
    private final Clasificator clasificator;

    public FileUploadController(Clasificator clasificator) 
    {
        this.clasificator = clasificator;
    }
    
    @GetMapping("/inserare")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Fișierul este gol!");
            return "upload";
        }

        // Verificare extensie fișier
        String fileName = file.getOriginalFilename();
        if (fileName == null || !fileName.toLowerCase().endsWith(".xlsx")) {
            model.addAttribute("message", "Doar fișiere .xlsx sunt permise!");
            return "upload";
        }

        try 
        {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) 
            {
                directory.mkdirs(); // Creează directorul dacă nu există
            }
            
            // Verificare dacă fișierul există deja
            File existingFile = new File(directory, fileName);
            if (existingFile.exists()) {
                model.addAttribute("message", "Fișierul '" + fileName + "' a fost deja încărcat!");
                return "upload";
            }
            
            // Salvare fișier în directorul local
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            
            String filePathString = path.toAbsolutePath().toString();
            System.out.println("Fișierul a fost salvat la: " + filePathString);
            
            clasificator.clasifica(filePathString);

            // Afișare rezultat clasificare
            model.addAttribute("message", "Fișier încărcat cu succes: " + fileName);
        } 
        catch (Exception e) 
        {
            model.addAttribute("message", "Eroare la salvarea sau clasificarea fișierului: " + e.getMessage());
        }

        return "upload";
    }
    
    // Handler pentru fișiere care depășesc dimensiunea maximă
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException e, Model model) {
        model.addAttribute("message", "Fișierul este prea mare! Dimensiunea maximă permisă este de " + maxFileSize + ".");
        return "upload"; // Returnează utilizatorul la pagina de upload
    }
}


