package com.example.imran.Library.Management.System.service.serviceImpl;

import com.example.imran.Library.Management.System.dto.AdminDto;
import com.example.imran.Library.Management.System.entity.Admin;
import com.example.imran.Library.Management.System.repository.AdminRepository;
import com.example.imran.Library.Management.System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public AdminDto findAdminById(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with given id"));
        AdminDto adminDto = new AdminDto();
        adminDto.setAdminName(admin.getAdminName());
        adminDto.setId(admin.getId());
        adminDto.setAdminPhoneNumber(admin.getAdminPhoneNumber());
        return adminDto;
    }
}
