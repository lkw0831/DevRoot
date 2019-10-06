package com.loukaiwei;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class FileUploadController {

    @PostMapping("/upload")
    public @ResponseBody
    String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String all = System.getProperty("user.dir") + File.separator + "uploadRoot" + File.separator + file.getOriginalFilename();
        File fileToSave = new File(all);
//        file.transferTo(fileToSave);
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getCanonicalPath();
    }
}
