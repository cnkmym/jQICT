public class FactorValue {
	private int factorIndex;
	private String value;

	public int getFacorIndex() {
		return factorIndex;
	}

	public String getValue() {
		return value;
	}

	public FactorValue(int factorId, String value) {
		this.factorIndex = factorId;
		this.value = value;
	}
}
