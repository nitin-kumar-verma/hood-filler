package com.hoodfiller.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoodfiller.model.HoodFillerInputJSON;
import com.hoodfiller.util.MinimumWeightCalculatorUtil;

@RestController
public class HoodFillerController {
	@PostMapping(path = "hoodfiller", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity hoodFiller(@RequestBody HoodFillerInputJSON hoodFillerInputJSON) {
		try {
			List<Integer> minWeightsArray = MinimumWeightCalculatorUtil.getMinimumWeightArray(
					hoodFillerInputJSON.getHoodCapacity(), hoodFillerInputJSON.getPresentWeights());
			if (!CollectionUtils.isEmpty(minWeightsArray)) {
				return new ResponseEntity(minWeightsArray, HttpStatus.OK);
			} else {
				return new ResponseEntity("No possible solution, Try altering the input",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
