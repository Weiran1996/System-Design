package MapImplement;

class Entry<K, V> {
	final K key;
	V value;
	Entry<K, V> next;

	// key value和pointer 是为了每个bucket做成一个LinkedList
	public Entry(K key, V value, Entry<K, V> next) {
		this.key= key;
		this.value= value;
		this.next= next;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof Entry) {
			Entry entry= (Entry) obj;

			return key.equals(entry.getKey()) &&
				value.equals(entry.getValue());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash= 13;
		hash= 17 * hash + ((key == null) ? 0 : key.hashCode());
		hash= 17 * hash + ((value == null) ? 0 : value.hashCode());
		return hash;
	}

	@Override
	public String toString() {
		return "{" + key + ", " + value + "}";
	}
}
