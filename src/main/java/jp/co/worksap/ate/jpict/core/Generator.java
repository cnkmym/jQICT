package jp.co.worksap.ate.jpict.core;

public class Generator {

        private final Algorithm algorithm;

        public Generator(Algorithm algorithm) {
                this.algorithm = algorithm;
        }

        public CombinationList generate(ParameterList parameters,
                        int maxCombinationLimit) {
                return algorithm.generate(parameters, maxCombinationLimit);
        }

}
