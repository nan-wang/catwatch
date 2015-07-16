package org.zalando.catwatch.backend.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zalando.catwatch.backend.model.Contributor;
import org.zalando.catwatch.backend.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = Constants.API_RESOURCE_CONTRIBUTORS, produces = { APPLICATION_JSON_VALUE })
@Api(value = Constants.API_RESOURCE_CONTRIBUTORS, description = "the contributors API")
public class ContributorsApi {

	@ApiOperation(value = "Contributor", notes = "The Contributors endpoint returns all information like name, url, commits count, \nprojects count of all the Contributors for the selected filter. \n", response = Contributor.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "An array of Contributors of selected Github organization"),
			@ApiResponse(code = 0, message = "Unexpected error") })
	@RequestMapping(value = "",

	method = RequestMethod.GET)
	public ResponseEntity<Contributor> contributorsGet(
			@ApiParam(value = "List of github.com organizations to scan(comma seperated)", required = true) 
			@RequestParam(value = Constants.API_REQUEST_PARAM_ORGANIZATIONS, required = true) 
			String organizations, 
			
			@ApiParam(value = "Number of items to retrieve. Default is 5.") 
			@RequestParam(value = Constants.API_REQUEST_PARAM_LIMIT, required = false) 
			Integer limit, 
			
			@ApiParam(value = "Offset the list of returned results by this amount. Default is zero.") 
			@RequestParam(value = Constants.API_REQUEST_PARAM_OFFSET, required = false) 
			Integer offset, 
			
			@ApiParam(value = "Date from which to start fetching records from database(default = current_date)") 
			@RequestParam(value = Constants.API_REQUEST_PARAM_STARTDATE, required = false) 
			Date startDate, 
			
			@ApiParam(value = "Date till which records will be fetched from database(default = current_date)") 
			@RequestParam(value = Constants.API_REQUEST_PARAM_ENDDATE, required = false) 
			Date endDate, 
			
			@ApiParam(value = "parameter by which result should be sorted. '-' means descending order (default is count of commit)") 
			@RequestParam(value = Constants.API_REQUEST_PARAM_SORTBY, required = false) 
			String sortBy, 
			
			@ApiParam(value = "query paramater for search query (this will be contributor names prefix)") 
			@RequestParam(value = Constants.API_REQUEST_PARAM_Q, required = false) 
			String q

	) throws NotFoundException {
		//TODO do some magic!
		return new ResponseEntity<Contributor>(HttpStatus.OK);
	}

}