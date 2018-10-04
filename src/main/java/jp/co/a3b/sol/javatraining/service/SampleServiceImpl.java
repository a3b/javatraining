package jp.co.a3b.sol.javatraining.service;

import java.util.List;
import java.util.Optional;

/**
 * JUnit テストサンプル用のサービスインターフェース
 */
public interface SampleServiceImpl {
	/**
	 * すべてのデータを取得する
	 * @return
	 */
	public Optional<List<String>> findAll();

	/**
	 * 指定した id に対応する値を取得する
	 * @param id
	 * @return
	 */
	public Optional<String> findOne(String id);

	/**
	 * key に対応する value が不正なデータがとうかを確認する
	 * @param key
	 * @param value
	 * @return
	 */
	public <T> boolean validation(int key, T value);
}
