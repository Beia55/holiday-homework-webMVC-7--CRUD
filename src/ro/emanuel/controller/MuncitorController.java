package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.dao.MuncitorDAO;
import ro.emanuel.pojo.Muncitor;

@Controller
public class MuncitorController {
	
	// CRUD
	
	@RequestMapping(value="lista-muncitori.htm",method=RequestMethod.GET)
	public ModelAndView listaMuncitori() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Muncitor> muncitori = MuncitorDAO.getMuncitor();
		model.put("muncitori", muncitori);
	
		return new ModelAndView("muncitor/listare-muncitori.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-muncitor.htm",method=RequestMethod.GET)
	public ModelAndView detaliiMuncitor(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Muncitor mc = MuncitorDAO.getMuncitorById(id);
		model.put("medic",mc);
		return new ModelAndView("muncitor/detalii-muncitor.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-muncitor.htm",method=RequestMethod.GET)
	public ModelAndView arataAddFormMuncitor(Model model){
		Muncitor mc = new Muncitor();
		model.addAttribute("muncitorForm", mc);
		
		return new ModelAndView("muncitor/add-muncitor.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-muncitor.htm",method=RequestMethod.POST)
	public ModelAndView saveAddMuncitor(@ModelAttribute("muncitorForm") Muncitor mc, ModelMap model, BindingResult result){
		try {
			MuncitorDAO.createMuncitor(mc);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-muncitori.htm");
	}

	// delete
	
	@RequestMapping(value="delete-muncitor.htm",method=RequestMethod.GET)
	public ModelAndView deleteMuncitor(@RequestParam Integer id) throws SQLException{
		MuncitorDAO.deleteMuncitor(id);
		return new ModelAndView("redirect:/lista-muncitori.htm");
	}

	// update
	
	@RequestMapping(value="edit-muncitor.htm",method=RequestMethod.GET)
	public ModelAndView arataEditFormMuncitor(@RequestParam Integer id, Model model) throws SQLException{
		Muncitor mc = MuncitorDAO.getMuncitorById(id);
		model.addAttribute("muncitorForm", mc);
		
		return new ModelAndView("muncitor/editare-muncitor.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-muncitor.htm",method=RequestMethod.POST)
	public ModelAndView arataEditMuncitor(@ModelAttribute("muncitorForm") Muncitor mc, ModelMap model, BindingResult result){
		try {
			MuncitorDAO.updateMuncitor(mc);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-muncitori.htm");
	}
	
}