package test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import net.arnx.jsonic.JSON;

public class JsonTestMain {

	private static final Logger LOG = Logger.getLogger(JsonTestMain.class);

	@SuppressWarnings("null")
	public static void main(String[] args) {

		int exitCode = 0;

		try {
			LOG.info("処理を開始します。");

			Map<String, Object> jsonKeyValueMap = new LinkedHashMap<>();
			jsonKeyValueMap.put("id", 1);
			jsonKeyValueMap.put("no", "PR 1-1-1");
			jsonKeyValueMap.put("name", "ドレス名");
			jsonKeyValueMap.put("type", "クール");
			jsonKeyValueMap.put("brand", "スパイスコード");
			jsonKeyValueMap.put("rarerity", "SPR");
			jsonKeyValueMap.put("volume", "星のツバサ1弾");

			if (LOG.isDebugEnabled()) {
				for (String key : jsonKeyValueMap.keySet()) {
					LOG.debug("map:key=" + key + ",value=" + jsonKeyValueMap.get(key));
				}
			}

			String json = JSON.encode(jsonKeyValueMap);
			LOG.info(json);
			System.out.println(json);

			String test = null;
			// cause NullPointerException
			test.equals("");

		} catch (Exception e) {
			exitCode = 1;
			LOG.error("処理中に例外が発生しました。", e);

		} finally {
			LOG.info("ステータスコード:" + exitCode);
			LOG.info("処理を終了します。");
		}

		System.exit(exitCode);
	}
}
