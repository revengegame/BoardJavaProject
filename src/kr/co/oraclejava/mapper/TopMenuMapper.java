package kr.co.oraclejava.mapper;

import org.apache.ibatis.annotations.Select;

import kr.co.oraclejava.beans.BoardInfoBean;

import java.util.List;



public interface TopMenuMapper {

	//--게시판에 idx=? 값이 1,2,3,4 형식으로 나타내려면
	@Select ("select board_info_idx, board_info_name "+
			"from board_info_table " +
	        "order by board_info_idx")
     //하나가 아니기 때문에
    List<BoardInfoBean> getTopMenuList();

}
//select문을 처리할때, 데이터를 가져오려면 어떤 컬럼의 값을 bean으로 
//주입할 것인지 결정을 해줘야 하는데 이 역할을 하는 클래스가 Mapper
//클래스 반환 타입으로 선언