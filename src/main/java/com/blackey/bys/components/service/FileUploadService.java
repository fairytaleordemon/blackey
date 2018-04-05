package com.blackey.bys.components.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

    String uploadFile(HttpServletRequest request, MultipartFile file);

}
