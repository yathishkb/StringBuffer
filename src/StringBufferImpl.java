public class StringBufferImpl {
	char[] buffer;
	int length;
	int capacity;
	String strInstance;

	public StringBufferImpl() {
		this(16);
	}

	public synchronized StringBufferImpl append(String newStringAppend) {
		String str =strInstance.concat(newStringAppend);
		if (str == null)
			str = "null";
		if (length + str.length() > capacity) {
			int l = Math.max(length + str.length(), 2 * capacity);
			char[] b = new char[l];
			for (int i = 0; i < length; i++) {
				b[i] = buffer[i];
			}
			buffer = b;
			capacity = l;
		}
		for (int i = 0; i < str.length(); i++) {
			buffer[length + i] = str.charAt(i);
		}
		//strInstance = strInstance.concat(str);
		length += str.length();
		return this;
	}

	public String toString() {
		//System.out.println("BUFFER: "+buffer);
		//System.out.println("LENGTH: "+length);
		return new String(buffer, 0, length);
	}

	public StringBufferImpl(int len) {
		capacity = len;
		buffer = new char[capacity];
		length = 0;
	}
	
	public StringBufferImpl(String setString) {
		this.strInstance = setString;
	}
}
