package jp.co.a3b.sol.javatraining.controller;

import java.util.ArrayList;
import java.util.List;

import jp.co.a3b.sol.javatraining.service.SampleService;
import jp.co.a3b.sol.javatraining.service.SampleServiceImpl;

public class SampleController {
	private SampleService sampleService;

	public SampleController() {
		this.sampleService = new SampleServiceImpl();
	}

	public List<String> findAll() {
		return this.sampleService.findAll().orElseGet(() -> {
			List<String> list = new ArrayList<String>();
			list.add("Not Found.");
			return list;
		});
	}

	public String findOne(String id) {
		if(this.sampleService.validation()) {
			return this.sampleService.findOne(id).orElseGet(() -> {
				return "Not Found.";
			});
		} else {
			return "Invalid ID.";
		}
	}
}
