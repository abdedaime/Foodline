package net.te6.foodline.restController;

import java.util.List;

import net.te6.foodline.models.Command;
import net.te6.foodline.models.Food;
import net.te6.foodline.services.IfoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("food")
public class FoodController {
	@Autowired
	private IfoodService foodService;
	

	@RequestMapping(value = "/add-food", method = RequestMethod.POST)
	public ResponseEntity<?> createFood(@RequestBody Food food) {
		foodService.save(food);
		return new ResponseEntity<Food>(food, HttpStatus.ACCEPTED);
	}
  
	
	
	@RequestMapping(value = "/add-food1", method = RequestMethod.POST)
	public ResponseEntity<?> creatCommand(@RequestBody Command command) {
		//foodService.save(food);
		return new ResponseEntity<Command>(command, HttpStatus.ACCEPTED);
	}
	
	
	@RequestMapping(value = "/food-snack/{idSnack}", method = RequestMethod.GET)
	public ResponseEntity<?> foodBySnack(@PathVariable  long idSnack ) {
		 return new ResponseEntity<List<Food>>(foodService.getFoodsBySnack(idSnack), HttpStatus.ACCEPTED);
	}


}
