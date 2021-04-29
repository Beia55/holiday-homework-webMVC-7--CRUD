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

import ro.emanuel.dao.MedicDAO;
import ro.emanuel.pojo.Medic;

@Controller
public class MedicController {
	
	// CRUD
	
	@RequestMapping(value="lista-medici.htm",method=RequestMethod.GET)
	public ModelAndView listaMedici() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Medic> medici = MedicDAO.getMedic();
		model.put("medici", medici);
	
		return new ModelAndView("medic/listare-medici.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-medic.htm",method=RequestMethod.GET)
	public ModelAndView detaliiMedic(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Medic md = MedicDAO.getMedicById(id);
		model.put("medic",md);
		return new ModelAndView("medic/detalii-medic.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-medic.htm",method=RequestMethod.GET)
	public ModelAndView arataAddFormMedic(Model model){
		Medic md = new Medic();
		model.addAttribute("medicForm", md);
		
		return new ModelAndView("medic/add-medic.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-medic.htm",method=RequestMethod.POST)
	public ModelAndView saveAddMedic(@ModelAttribute("medicForm") Medic md, ModelMap model, BindingResult result){
		try {
			MedicDAO.createMedic(md);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-medici.htm");
	}

	// delete
	
	@RequestMapping(value="delete-medic.htm",method=RequestMethod.GET)
	public ModelAndView deleteMedic(@RequestParam Integer id) throws SQLException{
		MedicDAO.deleteMedic(id);
		return new ModelAndView("redirect:/lista-medici.htm");
	}

	// update
	
	@RequestMapping(value="edit-medic.htm",method=RequestMethod.GET)
	public ModelAndView arataEditFormMedic(@RequestParam Integer id, Model model) throws SQLException{
		Medic md = MedicDAO.getMedicById(id);
		model.addAttribute("medicForm", md);
		
		return new ModelAndView("medic/editare-medic.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-medic.htm",method=RequestMethod.POST)
	public ModelAndView arataEditMedic(@ModelAttribute("medicForm") Medic md, ModelMap model, BindingResult result){
		try {
			MedicDAO.updateMedic(md);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-medici.htm");
	}
	
}