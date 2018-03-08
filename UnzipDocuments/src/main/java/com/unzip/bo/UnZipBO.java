package com.unzip.bo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface UnZipBO {
	
	public void UnZipFiles() throws FileNotFoundException, IOException;

}
