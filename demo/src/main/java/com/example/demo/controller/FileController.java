package com.example.demo.controller;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;

import java.util.Map;
@RestController
public class FileController {

    @PostMapping("/duplicate-strings")
    public ResponseEntity<Map<String, Integer>> getDuplicateStrings() {
        try {
            File file = ResourceUtils.getFile("classpath:text_01.txt");
            return ResponseEntity.ok(FileService.findDuplicates(file));

        } catch (IOException e) {
            throw new FileNotFoundException("File not found");
        }
    }


}


