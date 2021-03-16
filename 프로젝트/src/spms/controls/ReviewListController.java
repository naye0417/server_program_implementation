package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.ReviewDao;
import spms.vo.Review;

@Component("/review/list.do")
public class ReviewListController implements Controller, DataBinding{
	ReviewDao reviewDao = null;
	
	public ReviewListController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		String shop_num = (String)model.get("shop_num");
		model.put("review", reviewDao.selectOneRev(shop_num));
		
		return "/detailPage/reviewList.jsp";
	}

	public Object[] getDataBinders() {
		return new Object[] {
			"shop_num", String.class,
		};
	}
}
