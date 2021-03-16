package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.LikeListDao;
import spms.dao.MemberDao;
import spms.dao.ReservationDao;
import spms.vo.LikeList;
import spms.vo.Member;
import spms.vo.Reservation;

@Component("/likeList/add.do")
public class LikeListAddController implements Controller, DataBinding {
	
	LikeListDao likeListDao = null;
	
	public LikeListAddController setLikeListnDao(LikeListDao likeListDao) {
		this.likeListDao = likeListDao;
		return this;
	}


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		LikeList likeList = (LikeList)model.get("likeList");
		if(likeList.getId() == null) {
			return "/auth/login.do";
		}else {
			likeListDao.insertLike(likeList);
			return "redirect:list.do";
		}
		
	}
	@Override
	public Object[] getDataBinders() {
		// key값 이름, 자동으로 생성해야 할 클래스 타입
		return new Object[] {
			"likeList", spms.vo.LikeList.class
		};
	}

}
