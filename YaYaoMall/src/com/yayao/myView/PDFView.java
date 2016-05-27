package com.yayao.myView;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.yayao.bean.User;

@Component("pdfView")
public class PDFView extends AbstractPdfView{
	private String fileName;
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String fName = fileName+".pdf";  
        // 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开    
			//response.setContentType("application/pdf");    
			response.setContentType("application/pdf");    
			response.setHeader("Content-Disposition", "inline; filename="+new String(fName.getBytes(),"iso8859-1")); 
		//设置中文
			BaseFont bfChinese = BaseFont.createFont("/config/SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

			com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);
		
			List<User> list = (List<User>) model.get("userList");
			writer.getInstance(document, new FileOutputStream(fName+".PDF"));
			document.open();
			//创建一个有list.size()列的表格  
			PdfPTable table = new PdfPTable(list.size());
	        //定义一个表格单元  
	        PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
	        //定义一个表格单元的跨度  
	        cell.setColspan(3); 
	        table.addCell(cell);
	        PdfPCell huserid = new PdfPCell(new Paragraph("ID",FontChinese));
	        PdfPCell huserEmail = new PdfPCell(new Paragraph("邮箱",FontChinese));
	        PdfPCell hlastLoginTime = new PdfPCell(new Paragraph("最后登录时间",FontChinese));  
	        table.addCell(huserid); 
	        table.addCell(huserEmail); 
	        table.addCell(hlastLoginTime); 
	        for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				PdfPCell userid = new PdfPCell(new Paragraph(user.getUserId().toString(),FontChinese));
		        PdfPCell userEmail = new PdfPCell(new Paragraph(user.getUserEmail(),FontChinese));
		        PdfPCell lastLoginTime = new PdfPCell(new Paragraph(user.getLastLoginTime().toLocaleString(),FontChinese));  

				table.addCell(userid);
				table.addCell(userEmail);
				table.addCell(lastLoginTime);
			}
	        document.add(table);
	        document.close();
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
