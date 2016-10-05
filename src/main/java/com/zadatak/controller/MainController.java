package com.zadatak.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zadatak.dao.SequenceDao;
import com.zadatak.dao.impl.MainDaoImpl;
import com.zadatak.delegate.LoginDelegate;
import com.zadatak.model.Sequence;
import com.zadatak.viewBean.LoginBean;

@Controller
public class MainController {
	
	@Autowired
	private LoginDelegate loginDelegate;
    
	@Autowired
	@Qualifier("seqDao")
	private SequenceDao sequenceDao;
	
	@Qualifier("maindaoimpl")
	private MainDaoImpl mainDaoImpl;

	private String username;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getdata() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	
	@RequestMapping(value="sendAuthenticationRequest",method=RequestMethod.POST)
	public ModelAndView authenticationRequest(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		try{
			if(username.isEmpty() || password.isEmpty()){
				model = new ModelAndView("index");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Username and password fields are required!");
			} else {
				boolean isValidUser = loginDelegate.isValidUser(username, password);
				if(isValidUser){
					model.setViewName("welcome");
					this.username = username;
					request.setAttribute("loggedInUser", username);
					List<Sequence> listSequences = sequenceDao.listOfSequences();
				    model.addObject("listSequences", listSequences);
				}else{
					model = new ModelAndView("index");
					model.addObject("loginBean", loginBean);
					request.setAttribute("message", "Wrong username or password!");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping(value = "backToList", method = RequestMethod.POST)
	public ModelAndView backToList(HttpServletRequest request,ModelAndView model) throws SQLException {
		model.setViewName("welcome");
		request.setAttribute("loggedInUser", this.username);
		List<Sequence> listSequences = sequenceDao.listOfSequences();
	    model.addObject("listSequences", listSequences);
	    return model;
	}
	
	@RequestMapping(value = "/newSequence", method = RequestMethod.GET)
	public ModelAndView newSequence(HttpServletRequest request,ModelAndView model) {
	    Sequence newSeq = new Sequence();
	    model.addObject("sequence", newSeq);
	    model.setViewName("sequenceForm");
	    request.setAttribute("loggedInUser", this.username);
	    return model;
	}
	
	@RequestMapping(value = "saveSequence", method = RequestMethod.POST)
	public ModelAndView saveSequence(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String purpose = request.getParameter("purpose");
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		//insert to database
		Sequence seq = new Sequence();
		seq.setPurpose(purpose);
		seq.setDate(timeStamp);
		seq.setSubmittedBy(this.username);
		sequenceDao.addNewSequence(seq);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		request.setAttribute("loggedInUser", this.username);
		List<Sequence> listSequences = sequenceDao.listOfSequences();
	    model.addObject("listSequences", listSequences);
	    return model;
	}
	
	@RequestMapping(value = "searchSequence", method = RequestMethod.POST)
	public ModelAndView searchSequence(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Sequence searchSeq = new Sequence();
		ModelAndView model = new ModelAndView();
		String searchValue = request.getParameter("searchValue");		
		searchSeq.setPurpose(searchValue);
		List<Sequence> listSequences = sequenceDao.listOfFoundedSequences(searchSeq.getPurpose());
	    model.addObject("listSequences", listSequences);
	    model.setViewName("welcome");
		return model;
		
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
	    model.setViewName("index");
	    request.setAttribute("message", "Successufully logged out!");
		return model;
		
	}
}