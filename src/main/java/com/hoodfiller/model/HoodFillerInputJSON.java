package com.hoodfiller.model;

import java.util.List;

public class HoodFillerInputJSON {
	private Integer hood_capacity;
	private List<Integer> present_weights;

	public Integer getHoodCapacity() {
		return hood_capacity;
	}


	public List<Integer> getPresentWeights() {
		return present_weights;
	}


	public void setHood_capacity(Integer hood_capacity) {
		this.hood_capacity = hood_capacity;
	}


	public void setPresent_weights(List<Integer> present_weights) {
		this.present_weights = present_weights;
	}


}
