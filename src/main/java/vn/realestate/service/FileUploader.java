package vn.realestate.service;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *
 * @author Do Hung Cuong
 */
public class FileUploader {
	
	public static final String IMAGE_RESOURCES = "resources/Images/";

    public static String uploadImage(CommonsMultipartFile commonsMultipartFiles, HttpServletRequest request, Model model) {
        String nameFile = commonsMultipartFiles.getOriginalFilename();
        if (!"".equals(nameFile)) {
            String dirFile = request.getServletContext().getRealPath(IMAGE_RESOURCES);
            File fileDir = new File(dirFile);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            try {
                commonsMultipartFiles.transferTo(new File(fileDir + File.separator + nameFile));
                model.addAttribute("uploadResult", "upload successfully");
                return nameFile;
            } catch (IOException | IllegalStateException e) {
            	nameFile = "";
                model.addAttribute("uploadResult", "upload error");
            }
        }
        return nameFile;
    }
}