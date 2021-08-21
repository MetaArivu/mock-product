/**
 * (C) Copyright 2021 Araf Karsh Hamid 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fusion.air.microservice.adapters.controllers;

import io.fusion.air.microservice.domain.models.Product;
import io.fusion.air.microservice.server.config.ServiceConfiguration;
import io.fusion.air.microservice.server.controller.AbstractController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * App Controller for the Service
 * 
 * @author arafkarsh
 * @version 1.0
 * 
 */
@Configuration
@RestController
// "/api/v1/product"
@RequestMapping("${service.api.path}")
@RequestScope
@Tag(name = "Product", description = "Product Service ")
public class AppControllerImpl extends AbstractController {

	// Set Logger -> Lookup will automatically determine the class name.
	private static final Logger log = getLogger(lookup().lookupClass());
	
	@Autowired
	private ServiceConfiguration serviceConfig;

	/**
	 * Get Product By Category
	 * 
	 * @return
	 */
    @Operation(summary = "Get the Product based on Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Get the product based on Category",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = "Invalid Product category name",
            content = @Content)
    })
	@GetMapping("/category/{category}")
	@ResponseBody
	public ResponseEntity<ArrayList<Product>> getByCategory(@PathVariable("category") String _category,
														HttpServletRequest request) throws Exception {
		log.info("|"+name()+"|Get Product by Category .. ");
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(new Product());
		return ResponseEntity.ok(plist);
	}

	/**
	 * Get Product By Category & Brand
	 *
	 * @return
	 */
	@Operation(summary = "Get the Product based on Category & Brand")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Get the product based on Category & Brand",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",
					description = "Invalid Product category name or brand name",
					content = @Content)
	})
	@GetMapping("/category/{category}/brand/{brand}")
	@ResponseBody
	public ResponseEntity<ArrayList<Product>> getByCategoryAndBrand(@PathVariable("category") String _category,
															@PathVariable("brand") String _brand,
															HttpServletRequest request) throws Exception {
		log.info("|"+name()+"|Get Product by Category & Brand .. ");
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(new Product());
		return ResponseEntity.ok(plist);
	}

	/**
	 * Add the Product
	 */
    @Operation(summary = "Add Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Add the Product",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = "Unable to add the Product",
            content = @Content)
    })
    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> addProduct(@RequestBody  Product _product) {
		log.info("|"+name()+"|Add Product ... ");
		HashMap<String,Object> status = new HashMap<String,Object>();
		status.put("Code", 200);
		status.put("Status", true);
		status.put("Message","Product added!");
		return ResponseEntity.ok(status);
    }

	/**
	 * Delete the Product
	 */
	@Operation(summary = "Delete Product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Delete the Product",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",
					description = "Unable to Delete the Product",
					content = @Content)
	})
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Map<String,Object>> cancel(@PathVariable("productId") String _productId) {
		log.info("|"+name()+"|Delete the Product ... "+_productId);
		HashMap<String,Object> status = new HashMap<String,Object>();
		status.put("Code", 200);
		status.put("Status", true);
		status.put("Message","Product Deleted!");
		return ResponseEntity.ok(status);
	}

	/**
	 * Update the Product
	 */
	@Operation(summary = "Update Product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Update the Product",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",
					description = "Unable to Update the Product",
					content = @Content)
	})
	@PutMapping("/update/{productId}")
	public ResponseEntity<Map<String,Object>> updateProduct(@PathVariable("productId") String _productId) {
		log.info("|"+name()+"|Request to Update productId... "+_productId);
		HashMap<String,Object> status = new HashMap<String,Object>();
		status.put("Code", 200);
		status.put("Status", true);
		status.put("Message","Product updated!");
		return ResponseEntity.ok(status);
	}
 }

