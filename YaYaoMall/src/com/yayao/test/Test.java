package com.yayao.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.criterion.Order;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.yayao.util.FileUploadUtil;
import com.yayao.util.ReadFromFile;

public class Test {
	private  AtomicInteger ai=new AtomicInteger(0);
	
	private int i=0;
	
	public static void PDFUtil() throws IOException, DocumentException{
		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream("Helloworld.PDF"));

		document.open();
		
		BaseFont bfChinese = BaseFont.createFont("/config/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

		//com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);
		Font FontChinese = new Font(bfChinese); 
		System.out.println(FontChinese.getFamilyname());
		document.add(new Paragraph("字体解决了",FontChinese));

		document.close();
  
	}
	
	public static void main(String[] args) throws ParseException {
		//int validCode=(int) (Math.random()*9000+1000);
		/*new Thread(new Runnable() {
			public void run() {
				System.out.println("123");
			}
		}).start();*/
		//System.out.println(new Integer(-0));
		//System.out.println(new Test().validCode);
		
		String a=null;
		String b="";
		String c=" ";
		Integer aa=null;
		Integer bb=0;
		Integer cc;
			System.out.println(bb);
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str="2011-5-31 14:40:50";
			String str2="2011-5-31 14:40:40";
			Date d=sim.parse(str);
			Date d2=sim.parse(str2);
			System.out.println(d);
			System.out.println(!(d2.after(d)));
		String bvb="sdfsdf/resources/sdf.dsf";
		System.out.println(bvb.indexOf("/resources"));
		System.out.println(bvb.substring(6));
		 com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(BaseFont.FONT_TYPE_TT, 12, com.lowagie.text.Font.NORMAL ); 
	        System.out.println(new Paragraph("聂跃",FontChinese));
		
			//PDFUtil();
	       String [] imgs={"http://www.baidu.com","http://www.yayao8.com"};
	       String imgstr = "";
	       for (int i = 0; i < imgs.length; i++) {
				imgstr+=imgs[i]+"图片分割";
			}
	       String[] path2=imgstr.split("图片分割");
	       System.out.println(imgstr);
	       System.out.println(path2[0]+path2[1]);
	       Map<String,String>map=new HashMap<String,String>();
	       map.put("a", "12");
	       System.out.println(map.get("b"));
	       String aaa = "Test";
	    String bbb = "aaa";
	    Test t=new Test();
	    //t.getClass().getMethod(bbb, new Class[]{}).invoke(t, Object[]{});
	    String orderWay="as";
	    switch (orderWay) {
		case "asc":
			aaa="asc";
			break;
		case "desc":
			aaa="desc";
			break;
		}
	    System.out.println(aaa);
		}


}
