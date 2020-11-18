package lv.rtu.ks.utils;

import java.util.Arrays;

public class ArrayUtil {

	public static int[] toArray(int... elements) {
		return Arrays.stream(elements).toArray();
	}

}
