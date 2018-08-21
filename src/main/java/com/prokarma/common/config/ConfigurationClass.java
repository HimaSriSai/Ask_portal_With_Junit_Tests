package com.prokarma.common.config;

import java.io.Serializable;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.prokarma.forgotpassword.dao.ForgotPasswordDaoImpl;
import com.prokarma.forgotpassword.service.ForgotPasswordServiceImpl;
import com.prokarma.forgotpassword.service.MailServiceImpl;
import com.prokarma.postquery.dao.PostQueryDaoImpl;
import com.prokarma.postquery.service.PostQueryServiceImpl;
import com.prokarma.searchquery.dao.SearchDaoImpl;
import com.prokarma.searchquery.service.SearchServiceImpl;
import com.prokarma.userprofile.dao.RetrieveUserProfileDaoImpl;
import com.prokarma.userprofile.dao.NewuserprofileImpl;
import com.prokarma.userprofile.dao.UpdateUserProfileDaoImpl;
import com.prokarma.userprofile.service.RetrieveUserProfileServiceImpl;
import com.prokarma.userprofile.service.NewUserServiceImpl;
import com.prokarma.userprofile.service.UpdateUserProfileServiceImpl;

/**
 * @author prokarma
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prokarma")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class ConfigurationClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	private transient Environment env;

	/**
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	/**
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionalmanager = new DataSourceTransactionManager();
		transactionalmanager.setDataSource(dataSource());
		return transactionalmanager;
	}

	/**
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	/**
	 * @return
	 */
	@Bean
	public NamedParameterJdbcTemplate namedparameterjdbctemplate() {
		return new NamedParameterJdbcTemplate(dataSource());

	}

	/**
	 * @return
	 */
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl() {
		final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.office365.com");
		mailSender.setPort(587);
		mailSender.setUsername(env.getProperty("spring.mailsource.mail"));
		mailSender.setPassword(env.getProperty("spring.mailsource.password"));
		final Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "true");
		return mailSender;
	}

	/**
	 * @return
	 */
	@Bean(name = "userProfileDao")
	public ForgotPasswordDaoImpl getForgotPasswordProfile() {

		return new ForgotPasswordDaoImpl();
	}

	/**
	 * @return
	 */
	@Bean(name = "mailService")
	public MailServiceImpl getMailService() {

		return new MailServiceImpl();
	}

	/**
	 * @return
	 */
	@Bean(name = "forgotpasswordservice")
	public ForgotPasswordServiceImpl forgotPasswordServiceImpl() {

		return new ForgotPasswordServiceImpl();
	}

	/**
	 * @return
	 */
	@Bean(name = "newUserService")
	public NewUserServiceImpl newUserServiceImpl() {
		return new NewUserServiceImpl();
	}

	/**
	 * @return
	 */
	@Bean(name = "newUserProfile")
	public NewuserprofileImpl newuserprofileImpl() {
		return new NewuserprofileImpl();
	}

	/**
	 * @return
	 */
	@Bean(name = "searchService")
	public SearchServiceImpl searchServiceImpl() {
		return new SearchServiceImpl();
	}

	/**
	 * @return
	 */
	@Bean(name = "searchDao")
	public SearchDaoImpl searchDaoImpl() {
		return new SearchDaoImpl();
	}

	/**
	 * @return
	 */
	@Bean
	public PostQueryDaoImpl postQueryDaoImpl() {
		return new PostQueryDaoImpl();
	}

	/**
	 * @return
	 */
	@Bean
	public PostQueryServiceImpl postQueryServiceImpl() {
		return new PostQueryServiceImpl();
	}

	/**
	 * @return
	 */
	@Bean
	public RetrieveUserProfileDaoImpl retrieveUserProfileDaoImpl() {
		return new RetrieveUserProfileDaoImpl();
	}

	/**
	 * @return
	 */
	@Bean
	public RetrieveUserProfileServiceImpl retrieveUserProfileServiceImpl() {
		return new RetrieveUserProfileServiceImpl();
	}

	/**
	 * @return
	 */
	@Bean
	public UpdateUserProfileDaoImpl updateUserProfileDaoImpl() {
		return new UpdateUserProfileDaoImpl();
	}

	/**
	 * @return
	 */
	@Bean
	public UpdateUserProfileServiceImpl updateUserProfileServiceImpl() {
		return new UpdateUserProfileServiceImpl();
	}

}