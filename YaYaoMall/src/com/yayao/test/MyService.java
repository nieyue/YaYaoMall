package com.yayao.test;

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
	
}
