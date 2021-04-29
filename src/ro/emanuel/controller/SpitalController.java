package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.dao.SpitalDAO;
import ro.emanuel.pojo.Spital;

@Controller
public class SpitalController {
	
	// read
	
	@RequestMapping(value="lista-spitale.htm",method=RequestMethod.GET)
	public ModelAndView listareSpitale() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Spital> spitale = SpitalDAO.getSpital();
		model.put("spitale", spitale);
	
		return new ModelAndView("spital/listare-spitale.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-spital.htm",method=RequestMethod.GET)
	public ModelAndView detaliiSpital(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Spital sp = SpitalDAO.getSpitalById(id);
		model.put("spital",sp);
		return new ModelAndView("spital/detalii-spital.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-spital.htm",method=RequestMethod.GET)
	public ModelAndView arataFormAddSpital(Model model){
		Spital sp = new Spital();
		model.addAttribute("spitalForm", sp);
		
		return new ModelAndView("spital/add-spital.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-spital.htm",method=RequestMethod.POST)
	public ModelAndView salveazaAddSrudent(@ModelAttribute("spitalForm") Spital sp, ModelMap model, BindingResult result){
		try {
			SpitalDAO.createSpital(sp);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-spitale.htm");
	}

	// delete
	
	@RequestMapping(value="delete-spital.htm",method=RequestMethod.GET)
	public ModelAndView deleteSpital(@RequestParam Integer id) throws SQLException{
		SpitalDAO.deleteSpitalByID(id);
		return new ModelAndView("redirect:/lista-spitale.htm");
	}

	// update
	
	@RequestMapping(value="edit-spital.htm",method=RequestMethod.GET)
	public ModelAndView arataFormEditSpital(@RequestParam Integer id, Model model) throws SQLException{
		Spital sp = SpitalDAO.getSpitalById(id);
		model.addAttribute("spitalForm", sp);
		
		return new ModelAndView("spital/editare-spital.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-spital.htm",method=RequestMethod.POST)
	public ModelAndView salveazaEditSpital(@ModelAttribute("studentForm") Spital sp, ModelMap model, BindingResult result){
		try {
			SpitalDAO.updateSpital(sp);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-spitale.htm");
	}
	
}