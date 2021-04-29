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

import ro.emanuel.dao.DirectorDAO;
import ro.emanuel.pojo.Director;

@Controller
public class DirectorController {
	
	// CRUD
	
	@RequestMapping(value="lista-directori.htm",method=RequestMethod.GET)
	public ModelAndView listaDirector() throws SQLException {
		ModelMap model = new ModelMap();
		
		ArrayList<Director> directori = DirectorDAO.getDirector();
		model.put("directori", directori);
	
		return new ModelAndView("director/listare-directori.jsp", model);
	}
	
	// datails
	
	@RequestMapping(value="detalii-director.htm",method=RequestMethod.GET)
	public ModelAndView detaliiDirector(@RequestParam Integer id) throws SQLException{
		ModelMap model = new ModelMap();

		Director md = DirectorDAO.getDirectorById(id);
		model.put("director",md);
		return new ModelAndView("director/detalii-director.jsp", model);
	}
	
	// create
	
	@RequestMapping(value="add-director.htm",method=RequestMethod.GET)
	public ModelAndView arataAddFormDirector(Model model){
		Director dr = new Director();
		model.addAttribute("directorForm", dr);
		
		return new ModelAndView("director/add-director.jsp", "model", model);
	}
	
	@RequestMapping(value="save-add-director.htm",method=RequestMethod.POST)
	public ModelAndView saveAddDirector(@ModelAttribute("directorForm") Director dr, ModelMap model, BindingResult result){
		try {
			DirectorDAO.createDirector(dr);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-directori.htm");
	}

	// delete
	
	@RequestMapping(value="delete-director.htm",method=RequestMethod.GET)
	public ModelAndView deleteDirector(@RequestParam Integer id) throws SQLException{
		DirectorDAO.deleteDirector(id);
		return new ModelAndView("redirect:/lista-directori.htm");
	}

	// update
	
	@RequestMapping(value="edit-director.htm",method=RequestMethod.GET)
	public ModelAndView arataEditFormDirector(@RequestParam Integer id, Model model) throws SQLException{
		Director dr = DirectorDAO.getDirectorById(id);
		model.addAttribute("directorForm", dr);
		
		return new ModelAndView("director/editare-director.jsp", "model", model);
	}
	
	@RequestMapping(value="save-edit-director.htm",method=RequestMethod.POST)
	public ModelAndView arataEditDirector(@ModelAttribute("directorForm") Director dr, ModelMap model, BindingResult result){
		try {
			DirectorDAO.updateDirector(dr);

		} catch (SQLException e){
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/lista-directori.htm");
	}
	
}