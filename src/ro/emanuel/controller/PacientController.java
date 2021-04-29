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

import ro.emanuel.dao.PacientDAO;
import ro.emanuel.pojo.Pacient;

@Controller
public class PacientController {
	
	// CRUD
	
	@RequestMapping(value="lista-pacienti.htm",method=RequestMethod.GET)
	public ModelAndView listaPacienti() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Pacient> pacienti = PacientDAO.getPacient();
		model.put("pacienti", pacienti);
	
		return new ModelAndView("pacient/listare-pacienti.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-pacient.htm",method=RequestMethod.GET)
	public ModelAndView detaliiPacient (@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Pacient md = PacientDAO.getPacientById(id);
		model.put("pacient",md);
		return new ModelAndView("pacient/detalii-pacient.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-pacient.htm",method=RequestMethod.GET)
	public ModelAndView arataAddFormPacient(Model model){
		Pacient md = new Pacient();
		model.addAttribute("pacientForm", md);
		
		return new ModelAndView("pacient/add-pacient.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-pacient.htm",method=RequestMethod.POST)
	public ModelAndView saveAddPacient(@ModelAttribute("pacientForm") Pacient md, ModelMap model, BindingResult result){
		try {
			PacientDAO.createPacient(md);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-pacienti.htm");
	}

	// delete
	
	@RequestMapping(value="delete-pacient.htm",method=RequestMethod.GET)
	public ModelAndView deletePacient(@RequestParam Integer id) throws SQLException{
		PacientDAO.deletePacient(id);
		return new ModelAndView("redirect:/lista-pacienti.htm");
	}

	// update
	
	@RequestMapping(value="edit-pacient.htm",method=RequestMethod.GET)
	public ModelAndView arataEditFormPacient(@RequestParam Integer id, Model model) throws SQLException{
		Pacient md =PacientDAO.getPacientById(id);
		model.addAttribute("pacientForm", md);
		
		return new ModelAndView("pacient/editare-pacient.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-pacient.htm",method=RequestMethod.POST)
	public ModelAndView arataEditPacient(@ModelAttribute("pacientForm") Pacient md, ModelMap model, BindingResult result){
		try {
			PacientDAO.updatePacient(md);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-pacienti.htm");
	}
	
}