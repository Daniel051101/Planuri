package ro.upt.ac.planuri.extractori;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;
import java.nio.file.Path;

@Controller
public class FileUploadController {

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

        try {
            // Salvare fișier în directorul local
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) 
            {
                directory.mkdirs();
            }
            
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
}


