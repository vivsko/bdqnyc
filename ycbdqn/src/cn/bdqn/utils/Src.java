package cn.bdqn.utils;

public class Src {
	/**
	 * 鑾峰緱鏂囨湰涓寮犲浘鐗囧湴鍧�
	 * 
	 * @param con
	 * @return
	 */
	public static String getsrc(String con) {
		int firstImg = con.indexOf("<img");
		String uri = "";
		if (firstImg != -1) {
			int src = con.indexOf("src", firstImg);
			if (src != -1) {
				int begin = con.indexOf("\"", src) + 1;
				int end = con.indexOf("\"", begin);
				if (end > begin) {
					uri = con.substring(begin, end).replaceAll("\n", "");
				}
			}
		}
		return uri;
	}
	
	/**
	 * 获得文本中去除首个图片 标签
	 * 
	 * @param con
	 * @return
	 */
	public static String getEle(String con) {
		StringBuffer buffer = new StringBuffer();
		int firstImg = con.indexOf("<img");
		if (firstImg != -1) {
			int img = con.indexOf("/>", firstImg);
			if (img != -1) {
				buffer.append(con.substring(0, firstImg));
				buffer.append(con.substring(img + 2, con.length()));
			}
		}
		return buffer.toString();
	}
}
