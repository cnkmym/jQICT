package jqict.core;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Combination {
        /**
         * Map<CombinationValue.id, CombinationValue>
         */
        private final Map<Long, CombinationValue> map;

        public Combination(List<CombinationValue> combinationValues) {
                super();
                this.map = new TreeMap<Long, CombinationValue>();
                for (CombinationValue combinationValue : combinationValues) {
                        this.map.put(combinationValue.getId(), combinationValue);
                }
        }

        public Map<Long, CombinationValue> getMap() {
                return map;
        }

        public CombinationValue get(Long id) {
                if (this.map.containsKey(id)) {
                        return this.map.get(id);
                } else {
                        return null;
                }
        }

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                String delim = "";
                for (CombinationValue cbv : map.values()) {
                        sb.append(delim);
                        sb.append(cbv.toString());
                        delim = ",";
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
