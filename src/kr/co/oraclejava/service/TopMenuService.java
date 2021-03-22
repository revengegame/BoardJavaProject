package kr.co.oraclejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.oraclejava.beans.BoardInfoBean;
import kr.co.oraclejava.dao.TopMenuDao;

@Service//~한 역할을 하는 명시적 선언
public class TopMenuService {

	@Autowired//TopMenuDao에 대한 서비스 객체 생성
	private TopMenuDao topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList= topMenuDao.getTopMenuList();
		
		return topMenuList;		
	}	
}
//서비스는 Dao에 있는 메소드를 호출하여 받아온 정보를 가지고 필요한 처리를
//해주는 역할을 한다