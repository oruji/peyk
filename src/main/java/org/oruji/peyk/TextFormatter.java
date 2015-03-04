package org.oruji.peyk;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class TextFormatter {

	private final static Map<String, String> emoticonMap = new TreeMap<String, String>() {
		{
			put("&gt;:D&lt;", "baghal");
			put(":))", "laugh");
			put(":((", "cry");
			put(":)", "1");
			put(":(", "2");
			put(":D", "3");
			put(":-h", "bye");
			put("(:|", "khamyaze");
			put("8-&gt;", "rolleyes");
			put("B-)", "shades");
			put(":\"&gt;", "shy");
			put(":-\"", "soot");
			put(":x", "love");
			put(":o", "taajjob");
			put(":-/", "confused");
			put("x(", "angry");
			put("I-)", "sleep");
			put(":-?", "think");
			put(":-p", "tongue");
		}
	};

	public static String emoticons(String text) {
		Iterator<Entry<String, String>> it = emoticonMap.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, String> pairs = it.next();
			String myPath = Main.class.getClassLoader()
					.getResource("emoticons/" + pairs.getValue() + ".gif")
					.toString();
			text = text.replaceAll(Pattern.quote(pairs.getKey()), "<img src=\""
					+ myPath + "\" />");
		}

		return text;
	}

	public static String buildStr(String text) {
		text = text.replaceAll(">", "&gt;").replace("<", "&lt;");
		return text;
	}
}