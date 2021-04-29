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

import ro.emanuel.dao.ProdusDAO;
import ro.emanuel.pojo.Produs;

@Controller
public class ProdusController {
	
	// CRUD
	
	@RequestMapping(value="lista-produse.htm",method=RequestMethod.GET)
	public ModelAndView listaProduse() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Produs> produse = ProdusDAO.getProdus();
		model.put("produse", produse);
	
		return new ModelAndView("produs/listare-produse.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-produs.htm",method=RequestMethod.GET)
	public ModelAndView detaliiProdus(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Produs pr = ProdusDAO.getProdusById(id);
		model.put("produs",pr);
		return new ModelAndView("produs/detalii-produs.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-produs.htm",method=RequestMethod.GET)
	public ModelAndView arataAddFormProdus(Model model){
		Produs pr = new Produs();
		model.addAttribute("produsForm", pr);
		
		return new ModelAndView("produs/add-produs.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-produs.htm",method=RequestMethod.POST)
	public ModelAndView saveAddProdus(@ModelAttribute("produsForm") Produs pr, ModelMap model, BindingResult result){
		try {
			ProdusDAO.createProdus(pr);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-produse.htm");
	}

	// delete
	
	@RequestMapping(value="delete-produs.htm",method=RequestMethod.GET)
	public ModelAndView deleteProdus(@RequestParam Integer id) throws SQLException{
		ProdusDAO.deleteProdus(id);
		return new ModelAndView("redirect:/lista-produse.htm");
	}

	// update
	
	@RequestMapping(value="edit-produs.htm",method=RequestMethod.GET)
	public ModelAndView arataEditFormProdus(@RequestParam Integer id, Model model) throws SQLException{
		Produs pr = ProdusDAO.getProdusById(id);
		model.addAttribute("produsForm", pr);
		
		return new ModelAndView("produs/editare-produs.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-produs.htm",method=RequestMethod.POST)
	public ModelAndView arataEditProdus(@ModelAttribute("produsForm") Produs pr, ModelMap model, BindingResult result){
		try {
			ProdusDAO.updateProdus(pr);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-produse.htm");
	}
	
}