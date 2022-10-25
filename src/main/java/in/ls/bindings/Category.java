package in.ls.bindings;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Category {

	private Integer catId;

	@NotBlank
	@Size(min=4)
	private String catName;

	@NotBlank
	@Size(min=10)
	private String catDesc;
	
	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	
}
