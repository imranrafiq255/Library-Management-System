package com.example.imran.Library.Management.System.service;

import com.example.imran.Library.Management.System.dto.AdminDto;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    AdminDto findAdminById(Long id);
}
