package com.prokarma.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.admin.model.FullNamesList;
import com.prokarma.admin.model.RequestDetails;
import com.prokarma.admin.model.ResponseMsg;
import com.prokarma.admin.services.IAdminService;

@RestController
@RequestMapping("/ask")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

	@RequestMapping(value = "/addEmpAsSme", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResponseMsg> addEmpAsSme(@RequestBody RequestDetails requestDetails) {

		ResponseMsg responseMsg = iAdminService.addAsSme(requestDetails);

		return new ResponseEntity<>(responseMsg, HttpStatus.OK);

	}

	@RequestMapping(value = "/getNames", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<FullNamesList> getNames() {

		FullNamesList FullNamesList = iAdminService.getFullNames();

		return new ResponseEntity<>(FullNamesList, HttpStatus.OK);
	}

}
