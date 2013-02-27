package jqict.core;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Combination {

	private final Map<String, CombinationValue> map;

	public Combination(List<CombinationValue> combinationValues) {
		super();
		this.map = new TreeMap<String, CombinationValue>();
		for (CombinationValue combinationValue : combinationValues) {
			this.map.put(combinationValue.getName(), combinationValue);
		}
	}

	public Map<String, CombinationValue> getMap() {
		return map;
	}
	
	
	public CombinationValue get(String name){
		return this.map.get(name);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (CombinationValue cbv : map.values()) {
			sb.append(cbv.toString());
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combination other = (Combination) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}
	
	
	

}
