package com.mypack.doa;

import java.util.List;

import com.mypack.model.Login;
import com.mypack.model.UploadFile;

public interface FileUploadDao {

 void save(UploadFile uploadFile);
 
 UploadFile getDocument(int file_id);
}
