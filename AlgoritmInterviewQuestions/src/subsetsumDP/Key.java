package subsetsumDP;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Key {
	private List<Integer> setOfInteger = new LinkedList<>();
	private int value;
	
	Key(List<Integer> list, int k) {
		this.setOfInteger = list;
		this.value = k;
	}
	
	public List<Integer> getSetOfInteger() {
		return setOfInteger;
	}
	public void setSetOfInteger(List<Integer> setOfInteger) {
		this.setOfInteger = setOfInteger;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((setOfInteger == null) ? 0 : setOfInteger.hashCode());
		result = prime * result + value;
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
		Key other = (Key) obj;
		if (setOfInteger == null) {
			if (other.setOfInteger != null)
				return false;
		} else if (!setOfInteger.equals(other.setOfInteger))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	

}