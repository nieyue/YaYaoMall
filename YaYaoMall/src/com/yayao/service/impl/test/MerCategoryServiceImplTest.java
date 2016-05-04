package com.yayao.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.yayao.bean.MerCategory;
import com.yayao.bean.UserLevel;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerSellerService;
import com.yayao.service.UserLevelService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerCategoryServiceImplTest {
	@Autowired
	@Qualifier("merCategoryService")
	MerCategoryService merCategoryService;
	@Autowired
	@Qualifier("merSellerService")
	MerSellerService merSellerService;
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		//session=sessionFactory.openSession();
		session=sessionFactory.openSession();
		System.out.println(session);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMerCategory() {
		MerCategory ul=new MerCategory();
		//ul.setCateName("青茶");
		//ul.setCateDesc("青茶（乌龙茶）是中国六大茶类之一，属于半发酵茶，既有绿茶的清香，又有红茶的浓郁。茶叶冲泡后，叶片中间呈绿色，边缘有明显的红边，因此有“绿叶红镶边”的美称。目前主要分布在福建，台湾和广东等地，在浙江，四川，江西等地也有少量生产。根据产地以及制茶工艺的不同，乌龙茶可以分为闽北乌龙茶，闽南乌龙茶，广东乌龙茶和台湾乌龙茶。其中闽北乌龙茶的代表名茶为大红袍，铁罗汉，水金龟，白鸡冠以及闽北水仙等；闽南乌龙茶的代表为安溪铁观音，黄金桂等；广东乌龙茶的代表名茶为凤凰单丛等；台湾乌龙的代表名茶为冻顶乌龙，阿里山乌龙等。");
		//merCategoryService.addMerCategory(ul);
	}

	@Test
	public void testUpdateMerCategory() {
		List<MerCategory> mc = merCategoryService.browseMerCategory(1);
		for (int i = 0; i < mc.size(); i++) {
			MerCategory merCategory = mc.get(i);
			merCategory.setMerSeller(merSellerService.loadMerSeller(1));
			merCategoryService.updateMerCategory(merCategory);
		}
	}

	@Test
	public void testDelMerCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseMerCategory() {
		List<MerCategory> list = merCategoryService.browseMerCategory(1);
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
			System.out.println(list.get(i).getMercategoryid());
			System.out.println(list.get(i).getCateName());
			System.out.println(list.get(i).getCateDate());
		}
	}

	@Test
	public void testLoadMerCategory() {
		MerCategory mercate = merCategoryService.loadMerCategory(1,"黑茶");
	System.out.println(mercate.getCateDate());
	}

	@Test
	public void testChkMerCategory() {
		fail("Not yet implemented");
	}

}
