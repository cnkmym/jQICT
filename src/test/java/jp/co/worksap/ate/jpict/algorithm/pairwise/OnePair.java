package jp.co.worksap.ate.jpict.algorithm.pairwise;

public class OnePair {
        private Long param1Id;
        private String param1Value;
        private Long param2Id;
        private String param2Value;

        public OnePair(Long param1Id, String param1Value, Long param2Id,
                        String param2Value) {
                super();
                if (param1Id < param2Id) {
                        this.param1Id = param1Id;
                        this.param1Value = param1Value;
                        this.param2Id = param2Id;
                        this.param2Value = param2Value;
                } else {
                        this.param1Id = param2Id;
                        this.param1Value = param2Value;
                        this.param2Id = param1Id;
                        this.param2Value = param1Value;
                }
        }

        public Long getParam1Id() {
                return param1Id;
        }

        public String getParam1Value() {
                return param1Value;
        }

        public Long getParam2Id() {
                return param2Id;
        }

        public String getParam2Value() {
                return param2Value;
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime
                                * result
                                + ((param1Id == null) ? 0 : param1Id.hashCode());
                result = prime
                                * result
                                + ((param1Value == null) ? 0 : param1Value
                                                .hashCode());
                result = prime
                                * result
                                + ((param2Id == null) ? 0 : param2Id.hashCode());
                result = prime
                                * result
                                + ((param2Value == null) ? 0 : param2Value
                                                .hashCode());
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
                OnePair other = (OnePair) obj;
                if (param1Id == null) {
                        if (other.param1Id != null)
                                return false;
                } else if (!param1Id.equals(other.param1Id))
                        return false;
                if (param1Value == null) {
                        if (other.param1Value != null)
                                return false;
                } else if (!param1Value.equals(other.param1Value))
                        return false;
                if (param2Id == null) {
                        if (other.param2Id != null)
                                return false;
                } else if (!param2Id.equals(other.param2Id))
                        return false;
                if (param2Value == null) {
                        if (other.param2Value != null)
                                return false;
                } else if (!param2Value.equals(other.param2Value))
                        return false;
                return true;
        }

}
