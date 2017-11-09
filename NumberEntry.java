import java.util.Map.Entry;

public class NumberEntry<K,V extends Number> implements Entry<K, V>{

	private K key;
	private V value;
	
	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	@Override
	public V setValue(V value) {
		this.value=value;
		return value;
	}

	public NumberEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
