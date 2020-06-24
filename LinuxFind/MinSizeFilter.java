package LinuxFind;

public class MinSizeFilter extends Filter {
	int minSize;

	public MinSizeFilter(int minSize) {
		this.minSize= minSize;
	}

	@Override
	public boolean apply(File file) {
		return file.size > minSize;
	}
}
