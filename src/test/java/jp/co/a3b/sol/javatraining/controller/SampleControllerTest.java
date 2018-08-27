package jp.co.a3b.sol.javatraining.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
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

	// 共通の開始処理（テストケースの度に実行される）
	@Before
	public void setup() {
		System.out.println("テスト開始");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		when(this.sampleService.findAll()).thenReturn(Optional.empty());

		assertThat(this.sampleController.findAll(), hasItems("Not Found."));
	}

	@Test
	public void testFileOne() {
		String id = "testID";
		when(this.sampleService.validation(anyInt(), any())).thenReturn(true);
		when(this.sampleService.findOne(anyString())).thenReturn(Optional.of(id));

		assertEquals(this.sampleController.findOne(id), id);
	}

	@Test
	public void testFileOne存在するIDを指定() {
		String id = "testID";
		when(this.sampleService.validation(anyInt(), any())).thenReturn(false);
		when(this.sampleService.validation(1, id)).thenReturn(true);
		when(this.sampleService.findOne(anyString())).thenReturn(Optional.empty());
		when(this.sampleService.findOne(id)).thenReturn(Optional.of(id));

		assertEquals(this.sampleController.findOne(id), id);
	}

	@Test
	public void testFileOne存在しないIDを指定() {
		String id = "testID";
		String nonId = "testNonID";
		when(this.sampleService.validation(anyInt(), any())).thenReturn(false);
		when(this.sampleService.validation(1, id)).thenReturn(true);
		when(this.sampleService.findOne(anyString())).thenReturn(Optional.empty());
		when(this.sampleService.findOne(id)).thenReturn(Optional.of(id));

		assertEquals(this.sampleController.findOne(nonId), "Not Found.");
	}

	@Test
	public void testFileOne指定したIDが不正() {
		String id = "testID";
		when(this.sampleService.validation(anyInt(), any())).thenReturn(false);
		when(this.sampleService.findOne(anyString())).thenReturn(Optional.empty());
		when(this.sampleService.findOne(id)).thenReturn(Optional.of(id));

		assertEquals(this.sampleController.findOne(id), "Invalid ID.");
	}

}
