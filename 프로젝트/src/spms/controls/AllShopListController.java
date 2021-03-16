package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.dao.ReservationDao;
import spms.dao.ShopDao;
import spms.vo.Member;
import spms.vo.Shop;

@Component("/Allshop/list.do")
public class AllShopListController implements Controller{

	ShopDao shopDao;
	
	public AllShopListController setAllshopListDao(ShopDao shopDao) {
		this.shopDao = shopDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String shop_num = (String)model.get("shop_num");
		model.put("shop", shopDao.selectList());
		
		return "/detailPage/Shoplist.jsp";
		
	}

//	@Override
//	public Object[] getDataBinders() {
//		// key값 이름, 자동으로 생성해야 할 클래스 타입
//		return new Object[] {
//			"likeList", spms.vo.LikeList.class
//		};
//	}
}
