package jp.co.a3b.sol.javatraining.service;

import java.util.List;
import java.util.Optional;

public class SampleServiceImpl implements SampleService {

	@Override
	public Optional<List<String>> findAll() {
		return null;
	}

	@Override
	public Optional<String> findOne(String id) {
		return null;
	}

	@Override
	public <T> boolean validation(int key, T value) {
		return false;
	}

}
