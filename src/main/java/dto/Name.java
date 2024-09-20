package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Name {
	private String first;
	private String last;

	public Name() {
		this.first = first;
		this.last = last;
	}

	// Override equals() to compare the fields
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name = (Name) o;
		return Objects.equals(first, name.first) &&
				Objects.equals(last, name.last);
	}

	// Override hashCode() to generate consistent hash codes based on fields
	@Override
	public int hashCode() {
		return Objects.hash(first, last);
	}

	@Override
	public String toString() {
		return "Name(first=" + first + ", last=" + last + ")";
	}
}
