package LinuxFind;

public class TypeFilter extends Filter {
	String type;

	public TypeFilter(String type) {
		this.type= type;
	}

	@Override
	public boolean apply(File file) {
		return file.type.equals(type);
	}
}
