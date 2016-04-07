package com.yayao.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
















import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Comment;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.CommentService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;
import com.yayao.util.MyFile;
import com.yayao.util.MyFileURL;

/**
 * 专属定制订单
 * @author yy
 *
 */
@Scope("prototype")
@Controller("exclusiveCustom")
public class ExclusiveCustomAction extends BaseAction {
	
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;
	private String customCategory;//定制类别
	private String customName;//定制者的姓名
	private String customPhone;	//定制者的电话
	private String customDetails;	//详细要求
	private File customPicture;//上传的文件
	private String customPictureFileName;//上传的文件名
	private String customPictureContentType;//文件类型
	private String savePath;//存储路径
	
	
	public String getCustomPictureContentType() {
		return customPictureContentType;
	}
	public void setCustomPictureContentType(String customPictureContentType) {
		this.customPictureContentType = customPictureContentType;
	}
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getCustomPictureFileName() {
		return customPictureFileName;
	}
	public void setCustomPictureFileName(String customPictureFileName) {
		this.customPictureFileName = customPictureFileName;
	}
	public File getCustomPicture() {
		return customPicture;
	}
	public void setCustomPicture(File customPicture) {
		this.customPicture = customPicture;
	}
	
	public String getCustomCategory() {
		return customCategory;
	}
	public void setCustomCategory(String customCategory) {
		this.customCategory = customCategory;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getCustomPhone() {
		return customPhone;
	}
	public void setCustomPhone(String customPhone) {
		this.customPhone = customPhone;
	}
	
	public String getCustomDetails() {
		return customDetails;
	}
	public void setCustomDetails(String customDetails) {
		this.customDetails = customDetails;
	}
	/**
	 * 提交定制订单（增加定制）
	 * @return
	 * @throws Exception
	 */
	public String submitCustom() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member m = (Member) session.get("Member");
		if(m!=null){
		ExclusiveCustom exclusiveCustom=new ExclusiveCustom();
		exclusiveCustom.setCustomCategory(customCategory);
		exclusiveCustom.setMember(m);
		exclusiveCustom.setCustomName(customName);
		exclusiveCustom.setCustomPhone(customPhone);
        /** 输入流对象（用于读取上传的文件数据） */
        InputStream in = null;
        /** 输出流对象(用于将读取到的文件数据输出到服务端的另一个文件中) */
        FileOutputStream out = null;
      
        String savePath=ServletActionContext.getServletContext().getRealPath("/customPicture");
      // String savePath=ServletActionContext.getServletContext().getContextPath();
       //File savePath=new File("D:\\nieyue\\YaYaoXiangXiu\\customPicture");
        //上传的文件
        File file=customPicture;
        //文件名
        String filename=DateUtil.timeStamp()+customPictureFileName;
        if(file.length()>2097152){
        	this.addFieldError("fileError", "上传文件失败！请检查文件类型和大小！");
        	return "input";
        }
        if (file!=null&&filename.length()>=1){
        	//方法一
//        	File destFile=new File(new File(savePath),filename);
//        	FileUtils.copyFile(file, destFile);
			//方法二
        	in =new FileInputStream(this.getCustomPicture());
			out = new FileOutputStream(savePath+"\\"+filename);
			int length = 0;
			byte[] buffer= new byte[1024];
			while ((length=in.read(buffer,0,1024))!=-1){
				out.write(buffer,0,length);
			}
			in.close();
			out.close();
			logger.info("文件"+filename+"已经上传到了服务器上的"+savePath+"下");
			exclusiveCustom.setCustomPicture("customPicture/"+filename);
			exclusiveCustom.setCustomDate(DateUtil.getCurrentTime());
			exclusiveCustom.setCustomOrderNumber(DateUtil.getOrdersTime()+"d");
			exclusiveCustom.setCustomDetails(customDetails);
			exclusiveCustomService.addExclusiveCustom(exclusiveCustom);
			exclusiveCustomService.browseExclusiveCustom(m);
			return "success";
			} else{				
		logger.info("您没有上传文件!");
		this.addFieldError("fileError", "上传文件失败！请检查文件类型和大小！");
	    return "input";
	    }
	 }
		this.addFieldError("fileError", "您还没有登录，请登录后上传！");
		return "input";
	}
	/**
	 * 取消定制订单（撤销定制）
	 * @return
	 * @throws Exception
	 */
	public String cancelCustom() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member m = (Member) session.get("Member");
		String delCustomIndex = ActionContextUtil.getRequest().getParameter("delCustomIndex");
		Integer dci = new Integer(delCustomIndex);
		
		if(m!=null&&dci!=null){
				ExclusiveCustom ecs = exclusiveCustomService.loadExclusiveCustom(dci);
					exclusiveCustomService.delExclusiveCustom(dci);
					//删除图片
					final String fileName = MyFileURL.getFileName(ecs.getCustomPicture());
					savePath=ServletActionContext.getServletContext().getRealPath("/merchandisePicture/embroideryDetails");
					new Thread(new MyFile(){
						public void run() {
							delFile(savePath,fileName);
						}
					}).start();
					exclusiveCustomService.browseExclusiveCustom(m);
					commentService.browseMemCustomComment(m);
					return "success";
				
		}
		return "input";
	}

}