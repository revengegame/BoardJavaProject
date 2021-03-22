package kr.co.oraclejava.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.oraclejava.beans.ContentBean;
import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.dao.BoardDAO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Value("${path.upload}")
	private String path_upload;
	
	@Autowired
	private BoardDAO boardDao;
	
	@Resource(name="loginUserBean") 
	private UserBean loginUserBean;
	
	private String saveUploadFile(MultipartFile upload_file) {
		
		String file_name = System.currentTimeMillis() + "-" + upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return file_name;		
	}
	
	public void addContentInfo(ContentBean writeContentBean) {
		
		MultipartFile upload_file =  writeContentBean.getUpload_file();
		
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name); 
		}
		
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx()); 
		
		boardDao.addContentInfo(writeContentBean); 
		
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return boardDao.getBoardInfoName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx){
		return boardDao.getContentList(board_info_idx);
	
}
	
	public ContentBean getContentInfo(int content_idx) {
		return boardDao.getContentInfo(content_idx);
	}
	
	
	public void deleteContentInfo(int content_idx) {
		boardDao.deleteContentInfo(content_idx);
	}
	
	
}