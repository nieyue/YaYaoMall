package com.yayao.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;












import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Admin;
import com.yayao.bean.Category;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.AdminService;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;
import com.yayao.util.MyFile;
import com.yayao.util.MyFileURL;
import com.yayao.util.SHAutil;


/**
 * 管理员对商品的增删改查
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminMer")
public class AdminMerAction extends BaseAction{
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	private String ht_merName;//商品名
	private String ht_category;//商品类别
	private Double ht_price;//商品单价
	//private Double ht_sprice;//会员价
	private String ht_merModel;//商品型号
	private File ht_picture;//商品图片
	private String ht_pictureFileName;//上传的文件名
	private String ht_pictureContentType;//文件类型
	private String savePath;//存储路径
	private String ht_merDesc;//商品描述
	//private String ht_manufacturer;//制造商
	//private String ht_leaveFactoryDate;//商品出厂日期
	//private Integer ht_special;//商品特价
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getHt_pictureFileName() {
		return ht_pictureFileName;
	}
	public void setHt_pictureFileName(String ht_pictureFileName) {
		this.ht_pictureFileName = ht_pictureFileName;
	}
	public String getHt_pictureContentType() {
		return ht_pictureContentType;
	}
	public void setHt_pictureContentType(String ht_pictureContentType) {
		this.ht_pictureContentType = ht_pictureContentType;
	}
	public String getHt_merName() {
		return ht_merName;
	}
	public void setHt_merName(String ht_merName) {
		this.ht_merName = ht_merName;
	}
	public String getHt_category() {
		return ht_category;
	}
	public void setHt_category(String ht_category) {
		this.ht_category = ht_category;
	}
	public Double getHt_price() {
		return ht_price;
	}
	public void setHt_price(Double ht_price) {
		this.ht_price = ht_price;
	}
	
	public String getHt_merModel() {
		return ht_merModel;
	}
	public void setHt_merModel(String ht_merModel) {
		this.ht_merModel = ht_merModel;
	}
	public File getHt_picture() {
		return ht_picture;
	}
	public void setHt_picture(File ht_picture) {
		this.ht_picture = ht_picture;
	}
	public String getHt_merDesc() {
		return ht_merDesc;
	}
	public void setHt_merDesc(String ht_merDesc) {
		this.ht_merDesc = ht_merDesc;
	}
	
	/**
	 * 增加商品
	 * @return
	 * @throws Exception
	 */
	public String ht_addMerchandise() throws Exception {
		Admin a = (Admin) ActionContextUtil.getSession().get("Admin");
		if(ht_merName==null||ht_category==null||ht_merDesc==null||ht_merModel==null||ht_price==null
			||ht_merName.equals("")||ht_category.equals("")||ht_merDesc.equals("")||ht_merModel.equals("")||ht_price.equals("")){
			this.addFieldError("ht_addMerCategoryError", "※商品增加错误，请您检查后重新添加！");
			return "input";
		}
		if(ht_category!=null&&!ht_category.equals("0")&&a.getAdminType()==1){
		Merchandise mer=new Merchandise();
		mer.setMerName(ht_merName);
		mer.setCategory(merService.loadCategory(new Integer(ht_category)));;
		//mer.setLeaveFactoryDate(ht_leaveFactoryDate);
		//mer.setManufacturer(ht_manufacturer);
		mer.setMerDesc(ht_merDesc);
		mer.setMerModel(ht_merModel);
		mer.setPrice(ht_price);
		//mer.setSprice(ht_sprice);
		mer.setSpecial(0);
		/** 存放文件的文件夹 */
		String savePath = ServletActionContext.getServletContext().getRealPath("/merchandisePicture/embroideryDetails");
		 //savePath=new File("D:/yayaotupian").toString();
		/** 文件名 */
        String filename = null;
        /** 上传的文件 */
        File file = ht_picture;
        /** 输入流对象（用于读取上传的文件数据） */
        FileInputStream in = null;
        /** 输出流对象(用于将读取到的文件数据输出到服务端的另一个文件中) */
        FileOutputStream out = null;
		filename =DateUtil.timeStamp()+ht_pictureFileName;
		if (file==null||filename.length()<1){
				logger.info("您没有上传文件!");
				this.addFieldError("ht_addMerCategoryError", "上传文件失败！请检查文件类型和大小！");
			    return "input";
			}else if(file.length()>2097152){
	        	this.addFieldError("ht_addMerCategoryError", "上传文件失败！请检查文件类型和大小！");
	        	return "input";
			}else{				
				in =new FileInputStream(file);
				out = new FileOutputStream(savePath+"\\"+filename);
				int readed = 0;
				byte[] buffer= new byte[1024];
				while ((readed=in.read(buffer,0,1024))!=-1){
				         out.write(buffer,0,readed);
				}
				in.close();
				out.close();
				logger.info("文件"+filename+"已经上传到了服务器上的"+savePath+"下");
				mer.setPicture("merchandisePicture/embroideryDetails/"+filename);
				//mer.setPicture(filename);
				
			}  			
		 merService.addMer(mer);
		return "success";
		}else{
			this.addFieldError("ht_addMerCategoryError", "※商品增加错误，请您检查后重新添加！");
			return "input";
		}	
	}
	/**
	 * 增加特价商品
	 * @return
	 * @throws Exception
	 */
	
	public String ht_addSMer() throws Exception {
		Admin a = (Admin) ActionContextUtil.getSession().get("Admin");
		//检查商品类型是否存在，
		List list = merService.browseCategory();
		if(list!=null&&a.getAdminType()==1){
			Merchandise mer=new Merchandise();
			mer.setMerName(ht_merName);
			mer.setCategory(merService.loadCategory(new Integer(ht_category)));;
			//mer.setLeaveFactoryDate(ht_leaveFactoryDate);
			//mer.setManufacturer(ht_manufacturer);
			mer.setMerDesc(ht_merDesc);
			mer.setMerModel(ht_merModel);
			mer.setPrice(ht_price);
			//mer.setSprice(ht_sprice);
			//mer.setSpecial(ht_special);
			/** 存放文件的文件夹 */
			String dir = ServletActionContext.getServletContext().getRealPath("/Picture");
			/** 文件名 */
			String filename = null;
			/** 上传的文件 */
			File file = ht_picture;
			/** 输入流对象（用于读取上传的文件数据） */
			FileInputStream in = null;
			/** 输出流对象(用于将读取到的文件数据输出到服务端的另一个文件中) */
			FileOutputStream out = null;
			filename = file.getName();
			if (file==null||filename.length()<1){
				logger.info("您没有上传文件!");
			}else{				
				in =new FileInputStream(file);
				out = new FileOutputStream(dir+"/"+filename);
				int readed = 0;
				byte[] buffer= new byte[1024];
				while ((readed=in.read(buffer,0,1024))!=-1){
					out.write(buffer,0,readed);
				}
				in.close();
				out.close();
				logger.info("文件"+filename+"已经上传到了服务器上的"+dir+"下");
				mer.setPicture("/Picture/"+filename);
			}  			
			merService.addMer(mer);
			return "success";
		}else{
			this.addFieldError("ht_addMer", "※特价商品增加错误，请您检查后重新添加！");
			return "input";
		}	
	}
	/**
	 * 删除指定商品
	 * @return
	 * @throws Exception
	 */
	public String ht_delMerchandise() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String delMerIndex = ActionContextUtil.getRequest().getParameter("hln");
		Integer dmi=new Integer(delMerIndex);
		if(a!=null&&a.getAdminType()==1){
			//删除图片
			Merchandise mer = merService.loadMer(dmi);
			final String fileName = MyFileURL.getFileName(mer.getPicture());
			savePath=ServletActionContext.getServletContext().getRealPath("/merchandisePicture/embroideryDetails");
			//savePath=new File("D:/yayaotupian").toString();
			new Thread(new MyFile(){
				public void run() {
					delFile(savePath,fileName);
				}
			}).start();
			merService.delMer(dmi);
			
		}
		return null;
	}
	/**
	 * 批量删除商品
	 * @return
	 * @throws Exception
	 */
	public String ht_delAllMerchandise() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		Integer dmid=null;
		//获取索引
		String delMerAllIndex = ActionContextUtil.getRequest().getParameter("delIndexs");
		if(delMerAllIndex!=null&&!delMerAllIndex.equals("")){
			String[] dmids=delMerAllIndex.split(",");
			for (int i = 0; i < dmids.length; i++) {
				dmid=new Integer(dmids[i]);
			if(a!=null&&a.getAdminType().equals(1)){
				//删除图片
				Merchandise mer = merService.loadMer(dmid);
				final String fileName = MyFileURL.getFileName(mer.getPicture());
				savePath=ServletActionContext.getServletContext().getRealPath("/merchandisePicture/embroideryDetails");
				new Thread(new MyFile(){
					public void run() {
						delFile(savePath,fileName);
					}
				}).start();
				merService.delMer(dmid);
					}
				}
			}	
		return null;
	}
	/**
	 * 删除特价商品
	 * @return
	 * @throws Exception
	 */
	public String ht_delSMer() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String delMerIndex = ActionContextUtil.getRequest().getParameter("delMerIndex");
		Integer dmi=new Integer(delMerIndex);
		if(a!=null&&a.getAdminType()==1){
			String hql="from Merchandise as a order by a.id desc";
			List list=merService.browseMer(hql);
			for (int i = 0; i < list.size(); i++) {
				Merchandise mer=(Merchandise)list.get(i);
				if(mer.getId().equals(dmi)){
					merService.delMer(mer.getId());
					return "success";
				}
			}
		}
		return "input";
	}
	/**
	 * 更改商品
	 * @return
	 * @throws Exception
	 */
	public String ht_updateMerchandise() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String ht_merID = ActionContextUtil.getRequest().getParameter("ht_merID");
		Integer hmid=new Integer(ht_merID);
		if(ht_merName==null||ht_category==null||ht_merDesc==null||ht_merModel==null||ht_price==null
				||ht_merName.equals("")||ht_category.equals("")||ht_merDesc.equals("")||ht_merModel.equals("")||ht_price.equals("")){
				this.addFieldError("ht_addMerCategoryError", "※商品更改错误，请您检查后重新添加！");
				return "input";
			}
	
			if(ht_category!=null&&!ht_category.equals("0")&&a.getAdminType()==1){
			//删除图片
			Merchandise mer = merService.loadMer(hmid);
			final String fileName = MyFileURL.getFileName(mer.getPicture());
			savePath=ServletActionContext.getServletContext().getRealPath("/merchandisePicture/embroideryDetails");
			new Thread(new MyFile(){
				public void run() {
					delFile(savePath,fileName);
				}
			}).start();
			//商品更改
				mer.setMerName(ht_merName);
				mer.setCategory(merService.loadCategory(new Integer(ht_category)));;
				//mer.setLeaveFactoryDate(ht_leaveFactoryDate);
				//mer.setManufacturer(ht_manufacturer);
				mer.setMerDesc(ht_merDesc);
				mer.setMerModel(ht_merModel);
				mer.setPrice(ht_price);
				//mer.setSprice(ht_sprice);
				//mer.setSpecial(ht_special);
				/** 存放文件的文件夹 */
				String savePath = ServletActionContext.getServletContext().getRealPath("/merchandisePicture/embroideryDetails");
				/** 文件名 */
		        String filename = null;
		        /** 上传的文件 */
		        File file = ht_picture;
		        /** 输入流对象（用于读取上传的文件数据） */
		        FileInputStream in = null;
		        /** 输出流对象(用于将读取到的文件数据输出到服务端的另一个文件中) */
		        FileOutputStream out = null;
				filename =DateUtil.timeStamp()+ht_pictureFileName;
				if (file==null||filename.length()<1){
						logger.info("您没有上传文件!");
						this.addFieldError("ht_addMerCategoryError", "上传文件失败！请检查文件类型和大小！");
					    return "input";
					}else if(file.length()>2097152){
			        	this.addFieldError("ht_addMerCategoryError", "上传文件失败！请检查文件类型和大小！");
			        	return "input";
					}else{				
						in =new FileInputStream(file);
						out = new FileOutputStream(savePath+"\\"+filename);
						int readed = 0;
						byte[] buffer= new byte[1024];
						while ((readed=in.read(buffer,0,1024))!=-1){
						         out.write(buffer,0,readed);
						}
						in.close();
						out.close();
						logger.info("文件"+filename+"已经上传到了服务器上的"+savePath+"下");
						mer.setPicture("merchandisePicture/embroideryDetails/"+filename);
					}  			
				 merService.updateMer(mer);
				return "success";
				}else{
					this.addFieldError("ht_addMerCategoryError", "※商品更改错误，请您检查后重新添加！");
					return "input";
					}
	}
	/**
	 * 更改特价商品
	 * @return
	 * @throws Exception
	 */
	public String ht_modifySMer() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String modifyMerIndex = ActionContextUtil.getRequest().getParameter("modifyMerIndex");
		Integer mmi=new Integer(modifyMerIndex);
		if(a!=null&&a.getAdminType()==1){
			/** 存放文件的文件夹 */
			String dir = ServletActionContext.getServletContext().getRealPath("/Picture");
			/** 文件名 */
			String filename = null;
			/** 上传的文件 */
			File file = ht_picture;
			/** 输入流对象（用于读取上传的文件数据） */
			FileInputStream in = null;
			/** 输出流对象(用于将读取到的文件数据输出到服务端的另一个文件中) */
			FileOutputStream out = null;
			String hql="from Merchandise as a order by a.id desc";
			List list=merService.browseMer(hql);
			for (int i = 0; i < list.size(); i++) {
				Merchandise mer=(Merchandise)list.get(i);
				if(mer.getId().equals(mmi)){
					mer.setMerName(ht_merName);
					mer.setCategory(merService.loadCategory(new Integer(ht_category)));;
					//mer.setLeaveFactoryDate(ht_leaveFactoryDate);
					//mer.setManufacturer(ht_manufacturer);
					mer.setMerDesc(ht_merDesc);
					mer.setMerModel(ht_merModel);
					mer.setPrice(ht_price);
					//mer.setSprice(ht_sprice);
					//mer.setSpecial(ht_special);
					filename=file.getName();
					if (file==null||filename.length()<1){
						logger.info("您没有上传文件!");
					}else{				
						in =new FileInputStream(file);
						out = new FileOutputStream(dir+"/"+filename);
						int readed = 0;
						byte[] buffer= new byte[1024];
						while ((readed=in.read(buffer,0,1024))!=-1){
							out.write(buffer,0,readed);
						}
						logger.info("文件"+filename+"已经上传到了服务器上的"+dir+"下");
						mer.setPicture("/Picture/"+filename);
					}  			
					merService.updateMer(mer);
					return "success";
				}
			}
		}
		return "input";
	}
	/**
	 * 装载商品（浏览单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_showMerchandiseDesc() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String merID = ActionContextUtil.getRequest().getParameter("merID");
		Integer mid=new Integer(merID);
		if(a!=null&&a.getAdminType()==1){
			Merchandise merchandise = merService.loadMer(mid);
			JSONObject json=JSONObject.fromObject(merchandise);
			JSONArray jsonarray=JSONArray.fromObject(json);
			ActionContextUtil.getResponse().setCharacterEncoding("utf-8");
			ActionContextUtil.getResponse().getWriter().write(jsonarray.toString());
				
		}
		return null;
	}
	/**
	 * 装载特价商品（浏览单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_loadSMer() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String loadMerIndex = ActionContextUtil.getRequest().getParameter("loadMerIndex");
		Integer lmi=new Integer(loadMerIndex);
		if(a!=null&&a.getAdminType()==1){
			merService.loadMer(lmi);
			return "success";	
		}
		return "input";
	}
	/**
	 * 显示单个商品图片及信息
	 * @return
	 * @throws Exception
	 */
	public String ht_showMer() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String loadMerIndex = ActionContextUtil.getRequest().getParameter("loadMerIndex");
		Integer lmi=new Integer(loadMerIndex);
		if(a!=null&&a.getAdminType()==1){
			Merchandise mer = merService.loadMer(lmi);
			if(mer.getPicture()!=null){
			   ActionContextUtil.getRequest().setAttribute("picture", ".."+mer.getPicture().trim());	
			}else{
				ActionContextUtil.getRequest().setAttribute("picture", "../images/default.jpg");
			}
			return "success";	
		}
		return "input";
	}
	/**
	 * 显示单个特价商品图片及信息
	 * @return
	 * @throws Exception
	 */
	public String ht_showSMer() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String loadMerIndex = ActionContextUtil.getRequest().getParameter("loadMerIndex");
		Integer lmi=new Integer(loadMerIndex);
		if(a!=null&&a.getAdminType()==1){
			Merchandise mer = merService.loadMer(lmi);
			if(mer.getPicture()!=null){
				ActionContextUtil.getRequest().setAttribute("picture", ".."+mer.getPicture().trim());	
			}else{
				ActionContextUtil.getRequest().setAttribute("picture", "../images/default.jpg");
			}
			return "success";	
		}
		return "input";
	}
	/**
	 * 显示全部所有商品图片及信息
	 * @return
	 * @throws Exception
	 */
	public String ht_showAllMerchandise() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType()==1){
			merService.browseMer("from Merchandise as a order by a.id desc");
		}
		return null;
	}
	/**
	 * 模糊查询会员（一个或多个）
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_searchMerchandise() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String sc = ActionContextUtil.getRequest().getParameter("sc");
		if(a!=null&&a.getAdminType().equals(1)){
			List list =  merService.searchMerchandise(sc);
			ActionContextUtil.getSession().remove("merList");
			ActionContextUtil.getSession().put("merList", list);
			if(list==null||list.equals("")||list.isEmpty()){
				
			ActionContextUtil.getResponse().setCharacterEncoding("UTF-8");
			ActionContextUtil.getResponse().getWriter().write("没有该类账户！");;
			}
			
		}
		return null;	
		
	}
}