package com.energizeglobal.sqlgenerator.service;

import org.springframework.core.io.Resource;

public interface DownloadFile {

  Resource downloadFile(String filename, String filePath);
}
