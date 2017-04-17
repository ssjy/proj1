package io_p;

import java.io.Serializable;

public class SerData implements Serializable {

	private static final long serialVersionUID = 1234L;
	String str;
	int cnt;
	/**
	 * @param str
	 * @param cnt
	 */
	public SerData(String str, int cnt) {
		this.str = str;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "SerData [str=" + str + ", cnt=" + cnt + "]";
	}
	
	
}
