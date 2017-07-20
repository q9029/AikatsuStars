package test;

import java.util.LinkedHashMap;
import java.util.Map;

import net.arnx.jsonic.JSON;

public class JsonTestMain {

	public static void main(String[] args) {

		Map<String, Object> cardInfoMap = new LinkedHashMap<>();
		cardInfoMap.put("id", 1);
		cardInfoMap.put("no", "PR 1-1-1");
		cardInfoMap.put("name", "ドレス名");
		cardInfoMap.put("type", "クール");
		cardInfoMap.put("brand", "スパイスコード");
		cardInfoMap.put("rarerity", "SPR");
		cardInfoMap.put("volume", "星のツバサ1弾");
		cardInfoMap.put("img_url", "https://hogehoge.hogehoge.com/img/image.png");

		String json = JSON.encode(cardInfoMap);
		System.out.println(json);
		// {
		//  "id":1,
		//  "no":"PR 1-1-1",
		//  "name":"ドレス名",
		//  "type":"クール",
		//  "brand":"スパイスコード",
		//  "rarerity":"SPR",
		//  "volume":"星のツバサ1弾",
		//  "img_url":"https://hogehoge.hogehoge.com/img/image.png"
		// }
	}
}
