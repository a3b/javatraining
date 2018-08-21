package jp.co.a3b.sol.javatraining.service;

import java.util.List;
import java.util.Optional;

public interface SampleService {
	public Optional<List<String>> findAll();
	public Optional<String> findOne();
	public boolean validation();
}
