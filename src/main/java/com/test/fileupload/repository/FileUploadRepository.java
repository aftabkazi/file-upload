package com.test.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.fileupload.entity.FileUpload;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUpload,Long>{

}
