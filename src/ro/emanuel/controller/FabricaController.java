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

import ro.emanuel.dao.FabricaDAO;
import ro.emanuel.pojo.Fabrica;

@Controller
public class FabricaController {
	
	// CRUD
	
	@RequestMapping(value="lista-fabrici.htm",method=RequestMethod.GET)
	public ModelAndView listaMedici() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Fabrica> fabrici = FabricaDAO.getFabrica();
		model.put("fabrici", fabrici);
	
		return new ModelAndView("fabrica/listare-fabrici.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-fabrica.htm",method=RequestMethod.GET)
	public ModelAndView detaliiFabrica(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Fabrica fab = FabricaDAO.getFabricaById(id);
		model.put("fabrica",fab);
		return new ModelAndView("fabrica/detalii-fabrica.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-fabrica.htm",method=RequestMethod.GET)
	public ModelAndView arataAddFormFabrica(Model model){
		Fabrica fab = new Fabrica();
		model.addAttribute("fabricaForm", fab);
		
		return new ModelAndView("fabrica/add-fabrica.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-fabrica.htm",method=RequestMethod.POST)
	public ModelAndView saveAddFabrica(@ModelAttribute("fabricaForm") Fabrica fab, ModelMap model, BindingResult result){
		try {
			FabricaDAO.createFabrica(fab);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-fabrici.htm");
	}

	// delete
	
	@RequestMapping(value="delete-fabrica.htm",method=RequestMethod.GET)
	public ModelAndView deleteFabrica(@RequestParam Integer id) throws SQLException{
		FabricaDAO.deleteFabrica(id);
		return new ModelAndView("redirect:/lista-fabrici.htm");
	}

	// update
	
	@RequestMapping(value="edit-fabrica.htm",method=RequestMethod.GET)
	public ModelAndView arataEditFormFabrica(@RequestParam Integer id, Model model) throws SQLException{
		Fabrica fab = FabricaDAO.getFabricaById(id);
		model.addAttribute("fabricaForm", fab);
		
		return new ModelAndView("fabrica/editare-fabrica.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-fabrica.htm",method=RequestMethod.POST)
	public ModelAndView arataEditFabrica(@ModelAttribute("fabricaForm") Fabrica fab, ModelMap model, BindingResult result){
		try {
			FabricaDAO.updateFabrica(fab);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-fabrici.htm");
	}
	
}