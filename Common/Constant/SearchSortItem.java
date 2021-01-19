package Constant;

public enum SearchSortItem {

	BEST_SELLERS("Bán chạy");

	private final String sortName;

	SearchSortItem(final String value) {
		this.sortName = value;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the sort name.
	 * 
	 * @return String, the sort name
	 */
	public String getSortName() {
		return this.sortName;
	}
}
