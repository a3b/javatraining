package jp.co.a3b.sol.javatraining.controller;

import java.util.ArrayList;
import java.util.List;

import jp.co.a3b.sol.javatraining.service.SampleServiceImpl;

/**
 * JUnit テストサンプル用のコントローラクラス
 */
public class SampleController {
	// 依存するサービスクラス
	private final SampleServiceImpl sampleService;

	/**
	 * コンストラクタ
	 * @param sampleService
	 */
	public SampleController(SampleServiceImpl sampleService) {
		this.sampleService = sampleService;
	}

	/**
	 * すべてのデータを取得する<br />
	 * ・サービスクラスの findAll メソッドを呼び、データを取得する<br />
	 * ・データが存在する場合は、そのデータを返す<br />
	 * ・データが存在しない場合は、"Not Found."を 0 番目の要素に持つ List を返す<br />
	 * @return
	 */
	public List<String> findAll() {
		return this.sampleService.findAll().orElseGet(() -> {
			List<String> list = new ArrayList<String>();
			list.add("Not Found.");
			return list;
		});
	}

	/**
	 * 指定した ID に対応するデータを取得する<br />
	 * ・指定したIDが不正データでないか確認する（キー番号は「1」）
	 * ・サービスクラスの findOne メソッドを呼び、データを取得する<br />
	 * ・データが存在する場合は、そのデータを返す<br />
	 * ・データが存在しない場合は、"Not Found."を 0 番目の要素に持つ List を返す<br />
	 * @return
	 */
	public String findOne(String id) {
		if(this.sampleService.validation(1, id)) {
			return this.sampleService.findOne(id).orElseGet(() -> {
				return "Not Found.";
			});
		} else {
			return "Invalid ID.";
		}
	}
}
