package com.unzip.boImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.stereotype.Service;

import com.unzip.bo.UnZipBO;

@Service
public class UnZipBOImpl implements UnZipBO{

	@Override
	public void UnZipFiles() throws IOException {
		String fileLocation="D:\\Abhinay\\Learning\\Res.zip";
		String fileDestination="D:\\Abhinay\\Learning\\OtherLearning";
		
		File destDir = new File(fileDestination);
		
		if(!destDir.exists()) {
			System.out.println("Created Directory");
			destDir.mkdirs();
		}
		byte buffer[]=new byte[1024];
		FileInputStream fis= new FileInputStream(fileLocation);
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry zEntry = zis.getNextEntry();
		
		while(zEntry != null){
            String fileName = zEntry.getName();
            File newFile = new File(destDir + File.separator + fileName);
            System.out.println("Unzipping to "+newFile.getAbsolutePath());
            //create directories for sub directories in zip
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
            }
            fos.close();
            //close this ZipEntry
            zis.closeEntry();
            zEntry = zis.getNextEntry();
        }
		
		zis.closeEntry();
        zis.close();
        fis.close();
		
	}
	
	

}
