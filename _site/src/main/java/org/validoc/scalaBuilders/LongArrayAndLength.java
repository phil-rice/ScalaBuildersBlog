package org.validoc.scalaBuilders;

public class LongArrayAndLength {
	private long[] data;
	private int size = 0;

	public LongArrayAndLength(long[] data, int size) {
		this.data = data;
		this.size = size;
	}
	public LongArrayAndLength(int maxSize) {
		this.data = new long[maxSize];
	}

	public int add(long l) {
		data[size++] = l;
		return size - 1;
	}

	public long get(int index) {
		return data[index];
	}

	public int getSize() {
		return size;
	}
}