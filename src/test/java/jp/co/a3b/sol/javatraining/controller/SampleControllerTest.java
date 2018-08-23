package jp.co.a3b.sol.javatraining.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jp.co.a3b.sol.javatraining.service.SampleService;


public class SampleControllerTest {
	// テスト対象のクラス
	@InjectMocks
	private SampleController sampleController;

	// テスト対象が依存しているクラス
	@Mock( name="sampleService" )
	private SampleService sampleService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFileOne() {
		String id = "testID";
		when(this.sampleService.validation()).thenReturn(true);
		when(this.sampleService.findOne(anyString())).thenReturn(Optional.of(id));

		assertEquals(this.sampleController.findOne(id), id);
	}

	@Test
	public void testFindAll() {
		when(this.sampleService.findAll()).thenReturn(Optional.empty());
		assertThat(this.sampleController.findAll(), hasItems("Not Found."));
		System.out.println(this.sampleController.findAll().get(0));
	}

}
