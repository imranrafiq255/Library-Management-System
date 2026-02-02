package com.example.imran.Library.Management.System.controller;

import com.example.imran.Library.Management.System.dto.AdminDto;
import com.example.imran.Library.Management.System.service.AdminService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/")
    public ResponseEntity<AdminDto> getAdminWithId(@Valid @RequestBody AdminDto adminDto){
        return ResponseEntity.ok(adminDto);
    }
}
