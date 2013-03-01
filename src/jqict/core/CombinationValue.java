package jqict.core;

public class CombinationValue {
        private final Long id;
        private final String name;
        private final String value;

        public CombinationValue(Long id, String name, String value) {
                super();
                this.id = id;
                this.name = name;
                this.value = value;
        }

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getValue() {
                return value;
        }

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("{id:");
                sb.append(getId());
                sb.append(",name:");
                sb.append(getName());
                sb.append(",value:");
                sb.append(getValue());
                sb.append("}");
                return sb.toString();
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
                result = prime * result
                                + ((name == null) ? 0 : name.hashCode());
                result = prime * result
                                + ((value == null) ? 0 : value.hashCode());
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
                CombinationValue other = (CombinationValue) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                if (name == null) {
                        if (other.name != null)
                                return false;
                } else if (!name.equals(other.name))
                        return false;
                if (value == null) {
                        if (other.value != null)
                                return false;
                } else if (!value.equals(other.value))
                        return false;
                return true;
        }

}
