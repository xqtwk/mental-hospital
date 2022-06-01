package mental.mentalhospital.Controllers;

import mental.mentalhospital.Services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/")
    public String home() {
        return "upload.html";
    }

    @PostMapping("/")
    public String upload(@RequestParam("file") MultipartFile file) {
        fileStorageService.store(file);
        return home();
    }

    @GetMapping("/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename){

        Resource file= fileStorageService.loadFile(filename);
        if (file==null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity
                .ok()
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+filename+"\"") // download
                //.header(HttpHeaders.CONTENT_TYPE, fileStorageService.getContentType(filename)) // read(show)
                .body(file);


    }
}
