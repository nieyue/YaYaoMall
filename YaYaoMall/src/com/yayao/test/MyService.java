package com.yayao.test;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;



@Path("/")
public class MyService {
	final String XMLNS_NAMESPACE = "http://127.0.0.1:8080/rest/service";
	      final String ROOT_NODE = "root";
	  
	      @GET
	      @Path("/json/hello")
	      @Produces(MediaType.APPLICATION_JSON)
	      public JAXBElement<String> getHelloWorldJSON() {
	    	  JAXBElement<String> result = new JAXBElement<String>(new QName("",
	    			  ROOT_NODE), String.class, sayHelloWorld());
	    	  return result;
	      }
	      @GET
	      @Path("/xml/hello")
	      @Produces(MediaType.APPLICATION_XML)
	     public JAXBElement<String> getHelloWorldXML() {
	         JAXBElement<String> result = new JAXBElement<String>(new QName(XMLNS_NAMESPACE,
	                 ROOT_NODE), String.class, sayHelloWorld());
	         return result;
	     }

		private String sayHelloWorld() {
			// TODO Auto-generated method stub
			return "Hello JAX-RS!";
		}
		static int aaa=22;
		public int ah(int aa){
			return aa+1;
		}
		public int hh(){
			int aaa=2;
		 return ah(aaa);
		}
		public static void main(String[] args) {
			System.out.println(new MyService().hh());
			System.out.println((float)((int)((44.22+21.4)*.9*1000))/1000);
			System.out.println((float)((int)(((44.22+21.4)*.9)*1000))/1000);
			BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO; 
			BigDecimal[] prices = {BigDecimal.valueOf(0.0),BigDecimal.valueOf(44.22),BigDecimal.valueOf(4.20),BigDecimal.valueOf(21.4)};
			for(BigDecimal price : prices) { 
			if(price.compareTo(BigDecimal.valueOf(20)) > 0) 
			totalOfDiscountedPrices = 
			totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9))); 
			} 
			System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);  
		}
	
}
