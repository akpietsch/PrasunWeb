package dh.master.info.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dh.master.info.model.Work;
import dh.master.info.repository.WorkRepository;


@RestController
@RequestMapping("/prasun/works")
public class WorkController {
	
	@Autowired
	private WorkRepository workData;
	
	@RequestMapping(value="/listWorks", method = RequestMethod.GET)
	Page<Work> workPageable(Pageable pageable) {
		return workData.findAll(pageable);
		
	}
	

}
