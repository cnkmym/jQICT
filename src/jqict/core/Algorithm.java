package jqict.core;

public interface Algorithm {
        /**
         * 
         * @param domain
         * @param maxPatternLimit -1 means no up limit
         * @return
         */
        public CombinationTable generate(DimensionTable domain, int maxPatternLimit);

}
