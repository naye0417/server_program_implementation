package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.LikeListDao;
import spms.dao.MemberDao;
import spms.vo.LikeList;

@Component("/likeList/delete.do")
public class LikeListDeleteController implements Controller, DataBinding {
	
	LikeListDao likeListDao = null;
	
	public LikeListDeleteController setLikeListDao(LikeListDao likeListDao) {
		this.likeListDao = likeListDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		String shop_num = (String)model.get("shop_num");
		likeListDao.deleteLike(shop_num);
		
		return "redirect:list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"shop_num", String.class
		};
	}

}








