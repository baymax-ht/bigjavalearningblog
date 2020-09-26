package org.bigjava.bean;

import java.util.List;

public class Page<T> {
	public static final Integer PAGE_SIZE=4;
	//��ǰҳ��
	private Integer pageNo;
	//��ҳ��
	private Integer pageTotal;
	//��ǰҳ��ʾ����
	private Integer pageSize=PAGE_SIZE;
	//�ܼ�¼��
	private Integer pageTotalCount;
	//��ǰҳ����
	private List<T> items;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		if(pageNo<1) {
			pageNo=1;
		}if(pageNo>pageTotal) {
			pageNo=pageTotal;
		}
		this.pageNo = pageNo;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageSize=" + pageSize + ", pageTotalCount="
				+ pageTotalCount + ", items=" + items + "]";
	}
	

}
