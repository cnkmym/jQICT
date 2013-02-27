package jqict.core;



public class Generator{

	private final Algorithm algorithm;
	
	public Generator(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public CombinationTable generate(Domain domain) {
		return algorithm.generate(domain);
	}

	
}
