package MapImplement;

public class MyMap<K, V> {
	private Entry<K, V>[] buckets;
	private int capacity; // 16

	private int size= 0;

	// 这个是load factor
	private double lf= 0.75;

	public MyMap() {
		this(16);
	}

	public MyMap(int capacity) {
		this.capacity= capacity;
		this.buckets= new Entry[this.capacity];
	}

	public void put(K key, V value) {
		// 如果当前的size 已经是整个capacity的0.75倍了 就需要rehash
		// 这个是rehash的过程
		if (size == lf * capacity) {
			// rehash
			// 这是以前所有的entry
			Entry<K, V>[] old= buckets;

			// 把bucket个数翻倍
			capacity*= 2;
			size= 0;
			buckets= new Entry[capacity];

			for (Entry<K, V> e : old) {
				while (e != null) {
					put(e.key, e.value);
					e= e.next;
				}
			}
		}
		// 这个是Entry得Constructor 新加进去的肯定next是null啊
		Entry<K, V> entry= new Entry<>(key, value, null);

		// bucket中的index
		int bucket= getHash(key) % getBucketSize();

		Entry<K, V> existing= buckets[bucket];
		// 当前这个bucket还没有人来过
		if (existing == null) {
			buckets[bucket]= entry;
			size++ ;
		} else {
			// compare the keys see if key already exists
			// 如果有重复的 就更新对应的value
			while (existing.next != null) {
				if (existing.key.equals(key)) {
					existing.value= value;
					return;
				}
				existing= existing.next;
			}

			// 这是看最尾巴的那个
			if (existing.key.equals(key)) {
				existing.value= value;
			}
			// 就是放到了Linkedlist最尾巴的位置
			else {
				existing.next= entry;
				size++ ;
			}
		}
	}

	public V get(K key) {
		Entry<K, V> cur= buckets[getHash(key) % getBucketSize()];

		// 一直沿着当前的entry找下去
		while (cur != null) {
			if (key == cur.key) { return cur.value; }
			cur= cur.next;
		}
		return null;
	}

	public int size() {
		return size;
	}

	private int getBucketSize() {
		return buckets.length;
	}

	private int getHash(K key) {
		return key == null ? 0 : Math.abs(key.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for (Entry entry : buckets) {
			sb.append("[");
			while (entry != null) {
				sb.append(entry);
				if (entry.next != null) {
					sb.append(", ");
				}
				entry= entry.next;
			}
			sb.append("]");
		}
		return "{" + sb.toString() + "}";
	}
}
