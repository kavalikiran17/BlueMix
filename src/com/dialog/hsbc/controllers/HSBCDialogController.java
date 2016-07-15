package com.dialog.hsbc.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dialog.hsbc.dto.DialogDTO;
import com.dialog.hsbc.services.HSBCDialogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Controller
public class HSBCDialogController {

	@Autowired
	HSBCDialogService hsbcDialogService;
	
	public String clientMsg(
		    String clientMSG,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println(clientMSG);
		ObjectMapper mapper = new ObjectMapper();
		DialogDTO dialogDTO = new DialogDTO();
		try
		{
			dialogDTO = mapper.readValue(clientMSG, DialogDTO.class);
			System.out.println("Client Request:");
			System.out.println(dialogDTO);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(clientMSG);
		String responseMSG="";
		/*if(clientMSG.equalsIgnoreCase("\"input\":\"\"")){
			responseMSG="welcome";
		}
		else{*/
		DialogDTO responseDTO = hsbcDialogService.getNextDialog(dialogDTO);
			//responseMSG="hi";
		
		try {
			
			responseMSG = mapper.writeValueAsString(responseDTO);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println("Response String:" +responseMSG);
		/*String responseMSG="";
		if(dialogDTO.getInput()==null||"".equals(dialogDTO.getInput()))
		{
			responseMSG=jsonInString;
		}
		else
		{
			
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			responseMSG=jsonInString;
		}*/
		return responseMSG;
	}
	@PostConstruct
	protected void iamAlive(){
		System.out.println("inside controller");
	}
	
	
	@RequestMapping(value="clientVerify",method=RequestMethod.GET)
	@ResponseBody
	public String goGet(
			@RequestParam("clientMSG") String clientMSG,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		String resposeTxt= clientMsg(clientMSG,request,response);
		System.out.println("response text: "+resposeTxt);
		Gson gson=new Gson();
		 String json ="";
			 json = gson.toJson(resposeTxt);
		System.out.println(json);
		return resposeTxt;
	}
	
	
	@RequestMapping(value="clientResponse",method=RequestMethod.POST)
	@ResponseBody
	public String goPost(@RequestParam("clientMSG") String clientMSG,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		return clientMsg(clientMSG,request,response);
	}
	
}
