package jqict.core;

import java.util.List;


public class Domain {
	
	private final List<Dimension> dimensions;
	private final int size;

	public Domain(List<Dimension> dimensions) {
		super();
		this.dimensions = dimensions;
		int size = 1;
		for (Dimension dimension : dimensions) {
			 size = size * dimension.getValues().size();
		}
		this.size = size;
		
	}

	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public int getSize() {
		return size;
	}
	
	public String getValue(int x,int y){
		return dimensions.get(x).getValues().get(y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dimensions == null) ? 0 : dimensions.hashCode());
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
		Domain other = (Domain) obj;
		if (dimensions == null) {
			if (other.dimensions != null)
				return false;
		} else if (!dimensions.equals(other.dimensions))
			return false;
		return true;
	}
	
	
	
	
}
