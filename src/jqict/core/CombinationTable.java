package jqict.core;

import java.util.List;

public class CombinationTable {
	private final List<Combination> combinations;

	public CombinationTable(List<Combination> combinations) {
		super();
		this.combinations = combinations;
	}
	
	public List<Combination> getCombinations() {
		return combinations;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Combination cb : combinations) {
			sb.append(cb.toString());
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((combinations == null) ? 0 : combinations.hashCode());
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
		CombinationTable other = (CombinationTable) obj;
		if (combinations == null) {
			if (other.combinations != null)
				return false;
		} else if (!combinations.equals(other.combinations))
			return false;
		return true;
	}


}
