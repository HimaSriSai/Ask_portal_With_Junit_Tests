package com.prokarma.sme.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.sme.dao.ISmeDao;
import com.prokarma.sme.model.ResponseOnUpdate;
import com.prokarma.sme.model.SmeCtrgyName;
import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;
import com.prokarma.sme.services.ISmeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
@Transactional
public class SMEServiceTest {
	@Mock
	private ISmeDao iSmeDao;

	@Autowired
	@InjectMocks
	private ISmeService iSmeService;

	@Test
	public void testGetCtrgyName() {
		
		int empId = 6565 ;
		SmeCtrgyName responseCtrgyName = iSmeService.getCtrgyName(empId);
		List<String> result = responseCtrgyName.getCtrgyName();
		int size = result.size();
		assertEquals(0, size);

	}
	
	@Test
	public void testGetCtrgyNameCatch() {
		
		Integer empId = 0 ;
		SmeCtrgyName responseCtrgyName = iSmeService.getCtrgyName(empId);
		List<String> result = responseCtrgyName.getCtrgyName();
		int size = result.size();
		assertEquals(0, size);

	}

	
	@Test
	public void testUpdatePost() throws ParseException {
		UpdatePostQuery updatePostQuery = null;
		ResponseOnUpdate ResponseOnUpdate=iSmeService.updatePost(updatePostQuery);
		assertEquals("error while deleting posted query", ResponseOnUpdate.getResponseMsg());		
	}
	
	@Test
	public void testUpdateReply() throws ParseException {
		UpdateReplyQuery updateReplyQuery = null;
		ResponseOnUpdate ResponseOnUpdate=iSmeService.updateReply(updateReplyQuery);
		assertEquals("error while deleting reply query", ResponseOnUpdate.getResponseMsg());		
	}

}
